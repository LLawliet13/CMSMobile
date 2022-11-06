package com.example.cmsmobile.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.cmsmobile.R;
import com.example.cmsmobile.repository.RoleRepository;

public class HomeActivity extends AppCompatActivity {

    RoleRepository roleRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        roleRepository = new RoleRepository(this);
        if (roleRepository.getAllRoles().size() == 0)
            roleRepository.setUpRoles();
    }

    public void onLoginView(View view) {
        Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
        try {
            startActivity(intent);
        } catch (ActivityNotFoundException e) {
            sendBroadcast(intent);
        }

    }
}