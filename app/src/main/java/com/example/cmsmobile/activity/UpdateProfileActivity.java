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
import com.example.cmsmobile.validation.AccountValidation;

public class UpdateProfileActivity extends AppCompatActivity {
    private EditText username;
    private EditText address;
    private EditText phone;
    Bundle extras;
    Button saveButton,backButton;
    String email;
    AccountRepository accRepo;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        accRepo = new AccountRepository(this);
        setContentView(R.layout.activity_update_profile);
        username = findViewById(R.id.profile_username);
        address = findViewById(R.id.profile_address);
        phone = findViewById(R.id.profile_phone);
        extras = getIntent().getExtras();
        backButton = findViewById(R.id.profile_cancelbutton);
        saveButton = findViewById(R.id.profile_savebutton);
        Account acc = null;
        try {
            int account_id = getSharedPreferences("session",MODE_PRIVATE).getInt("account_id",0);
            acc = accRepo.getAccountById(account_id);
        } catch (Exception e) {
            acc = null;
            e.printStackTrace();
        }

        username.setText(acc.getUsername());
        address.setText(acc.getAddress());
        phone.setText(acc.getPhone());
        Account finalAcc = acc;
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finalAcc.setUsername(username.getText().toString());
                finalAcc.setAddress(address.getText().toString());
                finalAcc.setPhone(phone.getText().toString());
                updateProfile(finalAcc);
            }
        });
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }



    public void updateProfile(Account account) {
        try {
            AccountValidation.validate(account);
            accRepo.updateAccount(new Account());
            Toast.makeText(UpdateProfileActivity.this, "Update Successfully!", Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            Toast.makeText(UpdateProfileActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
}