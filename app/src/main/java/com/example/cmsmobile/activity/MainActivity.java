package com.example.cmsmobile.activity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.widget.ListView;

import com.example.cmsmobile.R;
import com.example.cmsmobile.adapter.RoleAdapter;
import com.example.cmsmobile.entity.Role;
import com.example.cmsmobile.repository.RoleRepository;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RoleRepository roleRepository;
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        roleRepository = new RoleRepository(this);
        roleRepository.setUpRoles();
        ListView roleListView = (ListView) findViewById(R.id.role_list);
        RoleAdapter adapter = new RoleAdapter(this,  roleRepository.getAllRoles().stream().toArray(Role[]::new));
        roleListView.setAdapter(adapter);
    }

}