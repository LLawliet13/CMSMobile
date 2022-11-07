package com.example.cmsmobile.activity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cmsmobile.R;
import com.example.cmsmobile.entity.Account;
import com.example.cmsmobile.repository.AccountRepository;

public class RecoverPasswordActivity extends AppCompatActivity {


    String account_name;
    EditText newPassword,cfNewPassword;
    Button savePassword,cancelButton;
    AccountRepository accountRepository;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recover_password);
        account_name = getIntent().getExtras().get("account_name").toString();
        newPassword = findViewById(R.id.new_password_recover_activity);
        cfNewPassword = findViewById(R.id.editText_cfpassword_recoverPassword);
        savePassword = findViewById(R.id.recover_password_button_recover_activity);
        cancelButton = findViewById(R.id.back_button_recover_activity);
        accountRepository = new AccountRepository(this);
        savePassword.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                String newPassEntered = newPassword.getText().toString();
                String cfPassEntered = cfNewPassword.getText().toString();
                try {
                    Account targetAccount = accountRepository.getAccountByEmail(account_name);
                    if(newPassEntered.equals(cfPassEntered)){
                        targetAccount.setPassword(newPassEntered);
                        accountRepository.updateAccount(targetAccount);
                        Toast.makeText(RecoverPasswordActivity.this,"Password Changed Successfully",Toast.LENGTH_LONG).show();
                    }else{
                        Toast.makeText(RecoverPasswordActivity.this,"Your new password and confirm new password doesn't match",Toast.LENGTH_LONG).show();
                    }
                    Intent intent = new Intent(RecoverPasswordActivity.this,HomeActivity.class);
                    startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecoverPasswordActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}