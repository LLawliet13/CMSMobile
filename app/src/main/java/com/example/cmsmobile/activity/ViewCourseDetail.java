package com.example.cmsmobile.activity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.TextView;

import com.example.cmsmobile.R;
import com.example.cmsmobile.entity.Account;
import com.example.cmsmobile.entity.Course;
import com.example.cmsmobile.repository.AccountRepository;
import com.example.cmsmobile.repository.CourseRepository;

public class ViewCourseDetail extends AppCompatActivity {

    Button view_feedback_btn, add_lecture_btn;
    Bundle extras;
    String course_name;
    TextView title;
    Course course;
    CourseRepository courseRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_course_detail);

        view_feedback_btn = findViewById(R.id.btn_view_course_feedback);
        add_lecture_btn = findViewById(R.id.btn_add_course_lecture);
        title = findViewById(R.id.course_title);

        courseRepository = new CourseRepository(this);
        extras = getIntent().getExtras();
        course_name = extras.getString("course_name");
        course = courseRepository.getCourseByName(course_name);

        title.setText("General Course: " + course_name);
        GridLayout link = findViewById(R.id.course_link);
        link.setVisibility(View.GONE);

        view_feedback_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewCourseDetail.this, ViewCourseFeedbackActivity.class);
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