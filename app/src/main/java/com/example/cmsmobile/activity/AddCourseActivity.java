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
import com.example.cmsmobile.repository.RoleRepository;

public class AddCourseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_course);
        Button save = findViewById(R.id.btn_save_course);
        Button cancel = findViewById(R.id.btn_cancel_course);
        EditText name = findViewById(R.id.txt_new_course_name);
        CourseRepository courseRepository = new CourseRepository(this);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                courseRepository.addCourse(new Course(name.getText().toString(), 1));
                Intent intent = new Intent(AddCourseActivity.this, ViewCourseDetail.class);
                intent.putExtra("CourseName",name.getText().toString());
                intent.putExtra("course_id",1);
                startActivity(intent);
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}