package com.example.cmsmobile.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cmsmobile.R;
import com.example.cmsmobile.entity.Course;
import com.example.cmsmobile.repository.CourseRepository;

import java.util.List;

public class AddCourseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_course);
        Button save = findViewById(R.id.btn_save_course);
        Button cancel = findViewById(R.id.btn_cancel_course);
        EditText course_name = findViewById(R.id.txt_new_course_name);
        CourseRepository courseRepository = new CourseRepository(this);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (course_name.getText().toString().isEmpty()) {
                    Toast.makeText(AddCourseActivity.this, "Course Name can't be empty!", Toast.LENGTH_SHORT).show();
                    return;
                }
                Course course = courseRepository.getCourseByName1(course_name.getText().toString());
                if (course != null){
                    Toast.makeText(AddCourseActivity.this, "Course Name already exist!", Toast.LENGTH_SHORT).show();
                    return;
                }
                String user_role = getSharedPreferences("session", Context.MODE_PRIVATE).getString("role", "student");
                if (user_role.equals("student")){
                    Toast.makeText(AddCourseActivity.this, "Student account can not own a course!", Toast.LENGTH_SHORT).show();
//                    return;
                }
                courseRepository.addCourse(new Course(course_name.getText().toString()));
                Intent intent = new Intent(AddCourseActivity.this, ViewCourseDetail.class);
                intent.putExtra("course_name",course_name.getText().toString());
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