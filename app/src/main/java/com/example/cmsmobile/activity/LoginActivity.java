package com.example.cmsmobile.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cmsmobile.R;
import com.example.cmsmobile.dao.AccountDAO;
import com.example.cmsmobile.dao.AccountRoomDatabase;
import com.example.cmsmobile.entity.Account;
import com.example.cmsmobile.repository.AccountRepository;

public class LoginActivity extends AppCompatActivity {
    private EditText editTextUserName, editTextPassword;
    Button LoginBtn, back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        back = findViewById(R.id.backBtn);
        LoginBtn = findViewById(R.id.LoginBtn);
        editTextUserName = findViewById(R.id.editTextUserName);
        editTextPassword = findViewById(R.id.editTextPassword);
        LoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = editTextUserName.getText().toString();
                String password = editTextPassword.getText().toString();
                if (username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Fill all field", Toast.LENGTH_LONG).show();
                } else {
                    AccountRoomDatabase accountRoomDatabase = AccountRoomDatabase.getDataBase(getApplicationContext());
                    AccountDAO accountDAO = AccountRoomDatabase.accountDAO();
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            Account account = accountDAO.Login(username,password);
                            if(account == null ){
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(getApplicationContext(), "Invalid", Toast.LENGTH_LONG).show();
                                    }
                                });
                            }else{
                                String name = account.getUsername();
                                Intent intent = new Intent(LoginActivity.this, HomeActivity.class).putExtra("name",name);
                                startActivity(intent);
                            }
                        }
                    }).start();

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
        startActivity(intent);
    }
}