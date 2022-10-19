package com.example.cmsmobile.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import com.example.cmsmobile.R;

public class UpdateProfileActivity extends AppCompatActivity {
    Bundle extras ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_profile);
        username = findViewById(R.id.profile_username);
        address = findViewById(R.id.profile_address);
        phone = findViewById(R.id.profile_phone);
        extras = getIntent().getExtras();
        username.setText(extras.getString("username"));
        address.setText(extras.getString("address"));
        phone.setText(extras.getString("phone"));
    }
    private EditText username;
    private EditText address;
    private EditText phone;

    public void updateProfile(){
    }
}