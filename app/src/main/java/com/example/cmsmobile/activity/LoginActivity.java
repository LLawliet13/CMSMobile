package com.example.cmsmobile.activity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cmsmobile.R;
import com.example.cmsmobile.dao.AccountDAO;
import com.example.cmsmobile.dao.AccountRoomDatabase;
import com.example.cmsmobile.entity.Account;
import com.example.cmsmobile.entity.Role;
import com.example.cmsmobile.repository.AccountRepository;
import com.example.cmsmobile.repository.RoleRepository;

import java.util.Optional;

public class LoginActivity extends AppCompatActivity {
    private EditText editTextUserName, editTextPassword;
    Button LoginBtn, back;
    private RoleRepository roleRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        roleRepository = new RoleRepository(this);
        back = findViewById(R.id.backBtn);
        LoginBtn = findViewById(R.id.LoginBtn);
        editTextUserName = findViewById(R.id.editTextUserName);
        editTextPassword = findViewById(R.id.editTextPassword);
        LoginBtn.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                String username = editTextUserName.getText().toString();
                String password = editTextPassword.getText().toString();
                if (username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Fill all field", Toast.LENGTH_LONG).show();
                } else {
//                    AccountRoomDatabase accountRoomDatabase = AccountRoomDatabase.getDataBase(getApplicationContext());
//                    AccountDAO accountDAO = AccountRoomDatabase.accountDAO();
                    AccountRepository accountRepository = new AccountRepository(LoginActivity.this);
                    Account account = accountRepository.Login(username, password);
                    if (account == null) {
                        Toast.makeText(getApplicationContext(), "Invalid", Toast.LENGTH_LONG).show();

                    } else {
                        Optional<Role> role = roleRepository.getAllRoles().stream().filter(r -> r.getRole_id() == account.getRole_id()).findAny();
                        SharedPreferences pref = getApplicationContext().getSharedPreferences("session", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = pref.edit();
                        editor.putInt("account_id", account.getAccount_id());
                        editor.putString("role", role.get().getName());
                        editor.commit();

                        Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                        startActivity(intent);
                    }
                }
            }
        });


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void registerUser(View view) {
        Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
        intent.putExtra("role_id", 3);
        startActivity(intent);

    }

}
