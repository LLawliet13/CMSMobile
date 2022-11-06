package com.example.cmsmobile.activity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cmsmobile.R;
import com.example.cmsmobile.entity.Account;
import com.example.cmsmobile.repository.AccountRepository;

import java.util.Optional;

public class RegisterActivity extends AppCompatActivity {

    Button registerButton,backButton;
    AccountRepository accountRepository;
    int role_id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        email = findViewById(R.id.editText_email);
        password = findViewById(R.id.editText_password);
        cfPassword = findViewById(R.id.editText_cfPassword);
        accountRepository = new AccountRepository(this);
        role_id = getIntent().getExtras().getInt("role");
        registerButton = findViewById(R.id.register_button);
        backButton = findViewById(R.id.register_back_button);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                register();
            }
        });
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private EditText email;
    private EditText password;
    private EditText cfPassword;

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void register() {
        try {
            String EmailValue = email.getText().toString();
            String passwordValue = password.getText().toString();
            String cfPasswordValue = cfPassword.getText().toString();

            if (passwordValue.equals(cfPasswordValue))
                throw new Exception("Password and cfPassword is not the same");

            if(EmailValue.isEmpty())
                throw new Exception("Email is not entered");

                Optional<Account> duplicatedAccount = accountRepository
                        .getAllAccounts().stream().filter( a -> a.getEmail() == EmailValue).findAny();
                if(duplicatedAccount.isPresent()){
                    throw  new Exception("This Email already exists");
                }

                Account account1 = new Account();
                account1.setEmail(email.getText().toString());
                account1.setPassword(password.getText().toString());
                account1.setRole_id(role_id);
                accountRepository.addAccount(account1);
                Toast.makeText(this,"register successfully",Toast.LENGTH_LONG).show();
                finish();
        } catch (Exception ex) {
            Toast.makeText(this,ex.getMessage(),Toast.LENGTH_LONG).show();
        }
    }
}