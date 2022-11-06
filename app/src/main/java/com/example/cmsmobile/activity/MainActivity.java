package com.example.cmsmobile.activity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.cmsmobile.R;
import com.example.cmsmobile.adapter.RoleAdapter;
import com.example.cmsmobile.entity.Account;
import com.example.cmsmobile.entity.Role;
import com.example.cmsmobile.repository.AccountRepository;
import com.example.cmsmobile.repository.RoleRepository;

import org.json.JSONObject;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RoleRepository roleRepository;
    private AccountRepository accountRepository;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        roleRepository = new RoleRepository(this);
        accountRepository = new AccountRepository(this);
//        roleRepository.setUpRoles();
//        accountRepository.addAccount(new Account("dung@gmail.com","123","dung"
//                ,"Thai binh","0123456789",1));
//
        ListView roleListView = (ListView) findViewById(R.id.role_list);
        RoleAdapter adapter = new RoleAdapter(this,  roleRepository.getAllRoles().stream().toArray(Role[]::new));
        roleListView.setAdapter(adapter);
        Button testButton = findViewById(R.id.select_button_mainactivity);
        testButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Account acc = accountRepository.getAccountByEmail("dung@gmail.com");
                    Intent i = new Intent(MainActivity.this, UpdateProfileActivity.class);
                    i.putExtra("username",acc.getUsername());
                    i.putExtra("address",acc.getAddress());
                    i.putExtra("phone",acc.getPhone());
                    i.putExtra("email",acc.getEmail());
                    startActivity(i);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });



    }


}