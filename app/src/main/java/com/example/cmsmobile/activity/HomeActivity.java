package com.example.cmsmobile.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.cmsmobile.R;
import com.example.cmsmobile.repository.AccountRepository;
import com.example.cmsmobile.repository.RoleRepository;

public class HomeActivity extends AppCompatActivity {
    TextView accountName;
    Button login_button;
    Button joinNow_button;
    Button logoutButton;
    RoleRepository roleRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        accountName = findViewById(R.id.accountName);
        String name = getIntent().getStringExtra("name");
        accountName.setText(name);
        login_button = findViewById(R.id.LoginBtnForHome);
        joinNow_button = findViewById(R.id.JoinNowButtonForHome);
        logoutButton = findViewById(R.id.logoutBtnHome);
        //gan logoutButton

        if (getSharedPreferences("session", Context.MODE_PRIVATE).getInt("account_id", 0) > 0) {
            login_button.setVisibility(View.GONE);
            joinNow_button.setVisibility(View.GONE);
            logoutButton.setVisibility(View.VISIBLE);
        } else {
            login_button.setVisibility(View.VISIBLE);
            joinNow_button.setVisibility(View.VISIBLE);
            logoutButton.setVisibility(View.GONE);
        }
        ;

    }

    public void onLogoutView(View view) {
        SharedPreferences pref = getApplicationContext().getSharedPreferences("session", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.remove("account_id");
        editor.commit();
        editor.clear();
        editor.commit();
        Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
        startActivity(intent);
    }

    public void onLoginView(View view) {
//        AccountRepository accountRepository = new AccountRepository(this);
//       accountRepository.execute();
//        roleRepository = new RoleRepository(this);
//        if (roleRepository.getAllRoles().size() == 0)
//            roleRepository.setUpRoles();
        Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
        try {
            startActivity(intent);
        } catch (ActivityNotFoundException e) {
            sendBroadcast(intent);
        }

    }
    public void SearchView(View view) {
        Intent intent = new Intent(HomeActivity.this, SearchCourseActivity.class);
        try {
            startActivity(intent);
        } catch (ActivityNotFoundException e) {
            sendBroadcast(intent);
        }

    }
}