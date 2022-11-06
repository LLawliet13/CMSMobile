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
import com.example.cmsmobile.entity.Announcement;
import com.example.cmsmobile.repository.AccountRepository;
import com.example.cmsmobile.repository.AnnouncementRepository;

import java.util.Optional;

public class ViewAnnouncementActivity extends AppCompatActivity {
private EditText title, description;
Button add;
AnnouncementRepository announcementRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_announcement);
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
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    private void add() {
        try {
            String name = title.getText().toString();
            String content = description.getText().toString();
           Announcement announcement = new Announcement();
            announcement.setName(title.getText().toString());
            announcement.setContent(description.getText().toString());
            announcementRepository.addAnnouncement(announcement);
            Toast.makeText(this,"Add announcement successfully",Toast.LENGTH_LONG).show();
            finish();
        } catch (Exception ex) {
            Toast.makeText(this,ex.getMessage(),Toast.LENGTH_LONG).show();
        }
    }
}