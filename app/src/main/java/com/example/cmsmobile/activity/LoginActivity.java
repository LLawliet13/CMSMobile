package com.example.cmsmobile.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cmsmobile.R;

public class LoginActivity extends AppCompatActivity {
    private EditText editTextUserName, editTextPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }

    public void onLogin(View view) {
        Intent intent = new Intent(this, LoginActivity.class);
        if(editTextUserName.getText().toString().length()>0){
            intent.putExtra("UserName", editTextUserName.getText().toString());
        }else{
            Toast.makeText(this,"Username and password is required",Toast.LENGTH_LONG).show();
            editTextUserName.setError("Username is required");
            editTextPassword.setError("Password is required");
        }
        startActivity(intent);
    }
    public void registerUser(View view){
        Intent intent = new Intent(getApplicationContext(),RegisterActivity.class);
        startActivity(intent);
    }
}