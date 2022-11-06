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
import com.example.cmsmobile.entity.Course;
import com.example.cmsmobile.entity.Role;
import com.example.cmsmobile.repository.CourseRepository;

import java.util.List;
import java.util.Optional;

public class SearchCourseActivity extends AppCompatActivity {
    EditText searchTxt;
    Button search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_course);
        CourseRepository courseRepository = new CourseRepository(this);
        searchTxt = findViewById(R.id.searchTxt);
        search = findViewById(R.id.searchBtn);
        search.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                String searchName = searchTxt.getText().toString();
                List<Course> course = courseRepository.getCourseByName(searchName);
                if (course.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "No contain", Toast.LENGTH_LONG).show();

                } else {
                    Intent intent = new Intent(SearchCourseActivity.this, CourseItemSearchListActivity.class);
                    startActivity(intent);

                }}
            });
        }
    }
