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
import android.widget.ListView;
import android.widget.Toast;

import com.example.cmsmobile.R;
import com.example.cmsmobile.adapter.AnnouncementViewAdapter;
import com.example.cmsmobile.adapter.SearchAdapter;
import com.example.cmsmobile.entity.Account;
import com.example.cmsmobile.entity.Announcement;
import com.example.cmsmobile.entity.Course;
import com.example.cmsmobile.repository.AccountRepository;
import com.example.cmsmobile.repository.AnnouncementRepository;

import java.util.ArrayList;
import java.util.List;
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
        announcementRepository = new AnnouncementRepository(this);
        ListView announcementListView = (ListView) findViewById(R.id.list_announcement);
        List<Announcement> announcements = new ArrayList<>();
        announcements.addAll(announcementRepository.getAllAnnouncement());
        announcements.add(0, new Announcement());
        AnnouncementViewAdapter adapter = new AnnouncementViewAdapter(ViewAnnouncementActivity.this,announcements.stream().toArray(Announcement[]::new));
        announcementListView.setAdapter(adapter);

        add.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),AddAnnouncementActivity.class);
                startActivity(intent);
                SharedPreferences pref = getApplicationContext().getSharedPreferences("session", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = pref.edit();
            }
        });
    }

}