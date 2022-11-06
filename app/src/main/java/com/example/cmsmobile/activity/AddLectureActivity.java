package com.example.cmsmobile.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.example.cmsmobile.R;
import com.example.cmsmobile.entity.Course;
import com.example.cmsmobile.entity.Lecture;
import com.example.cmsmobile.repository.CourseRepository;
import com.example.cmsmobile.repository.LectureRepository;

import java.sql.Date;

public class AddLectureActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_lecture);

        Button save_btn = findViewById(R.id.btn_add_lecture);
        Button cancel_btn = findViewById(R.id.btn_cancel_lecture);
        EditText name = findViewById(R.id.et_lecture_name);
        EditText date = findViewById(R.id.et_lecture_date);
        EditText content = findViewById(R.id.et_lecture_content);
        LectureRepository lectureRepository = new LectureRepository(this);

        save_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lectureRepository.addLecture(new Lecture(name.getText().toString(),content.getText().toString(), 1, date.getText().toString()));
                Intent intent = new Intent(AddLectureActivity.this, ViewCourseDetail.class);
                startActivity(intent);
            }
        });
        cancel_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddLectureActivity.this, ViewCourseDetail.class);
                startActivity(intent);
            }
        });
    }
}