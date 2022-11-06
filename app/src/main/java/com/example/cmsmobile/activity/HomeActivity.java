package com.example.cmsmobile.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.cmsmobile.R;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void onLoginView(View view) {
        Intent intent = new Intent(HomeActivity.this,LoginActivity.class);
        try {
            startActivity(intent);
        } catch (ActivityNotFoundException e){
            sendBroadcast(intent);
        }

    }
}