package com.example.cmsmobile.activity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cmsmobile.R;
import com.example.cmsmobile.entity.Announcement;
import com.example.cmsmobile.repository.AnnouncementRepository;

public class AddAnnouncementActivity extends AppCompatActivity {
    private EditText title, description;
    Button add,cancel;
    AnnouncementRepository announcementRepository;
    int account_id, currentAccountId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences pref = getApplicationContext().getSharedPreferences("session", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        currentAccountId = getSharedPreferences("session", Context.MODE_PRIVATE).getInt("account_id", 0);
        account_id = 1;
        announcementRepository = new AnnouncementRepository(this);
        setContentView(R.layout.activity_add_announcement);
        title = findViewById(R.id.titleTxt);
        description = findViewById(R.id.descriptionTxt);
        add= findViewById(R.id.addAnnouncementBtn);
        add.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                add();
            }
        });
        cancel= findViewById(R.id.cancelBtn);
        cancel.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    private void add() {
        try {
            String name = title.getText().toString();
            String content = description.getText().toString();
            Announcement announcement = new Announcement();
            announcement.setName(name);
            announcement.setContent(content);
            announcementRepository.addAnnouncement(announcement);
            if(name.isEmpty() || content.isEmpty()){
                Toast.makeText(this,"Fill all field!",Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(this,"Add announcement successfully",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(this,ViewAnnouncementActivity.class);
                startActivity(intent);
//            finish();
            }
        } catch (Exception ex) {
            Toast.makeText(this,"Cant add announcement",Toast.LENGTH_LONG).show();
        }
    }
    }
