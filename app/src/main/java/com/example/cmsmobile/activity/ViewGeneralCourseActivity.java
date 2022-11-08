package com.example.cmsmobile.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.cmsmobile.R;
import com.example.cmsmobile.repository.LectureRepository;

public class ViewGeneralCourseActivity extends AppCompatActivity {

    LectureRepository lectureRepository;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_general_course);
        lectureRepository = new LectureRepository(this);
    }
}