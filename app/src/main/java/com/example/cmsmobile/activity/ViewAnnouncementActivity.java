package com.example.cmsmobile.activity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
        add= findViewById(R.id.btnAddAnnouncement);
        add.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),AddAnnouncementActivity.class);
                startActivity(intent);
            }
        });
    }

}