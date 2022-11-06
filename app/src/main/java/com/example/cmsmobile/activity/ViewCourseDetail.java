package com.example.cmsmobile.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.cmsmobile.R;
import com.example.cmsmobile.entity.Course;
import com.example.cmsmobile.repository.CourseRepository;

public class ViewCourseDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_course_detail);

        Button view_feedback_btn = findViewById(R.id.btn_view_course_feedback);
        Button view_exam_btn = findViewById(R.id.btn_view_course_exam);
        Button add_lecture_btn = findViewById(R.id.btn_add_course_lecture);

        view_feedback_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewCourseDetail.this, ViewCourseFeedbackActivity.class);
                startActivity(intent);
            }
        });
        view_exam_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewCourseDetail.this, ViewExamActivity.class);
                startActivity(intent);
            }
        });
        add_lecture_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewCourseDetail.this, AddLectureActivity.class);
                startActivity(intent);
            }
        });
    }
}