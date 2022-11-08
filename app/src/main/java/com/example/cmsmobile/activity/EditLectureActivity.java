package com.example.cmsmobile.activity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cmsmobile.R;
import com.example.cmsmobile.entity.Course;
import com.example.cmsmobile.entity.Lecture;
import com.example.cmsmobile.repository.CourseRepository;
import com.example.cmsmobile.repository.LectureRepository;

public class EditLectureActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_lecture);

        Button save_btn = findViewById(R.id.btn_add_lecture);
        Button cancel_btn = findViewById(R.id.btn_cancel_lecture);
        EditText name = findViewById(R.id.et_lecture_name);
        EditText date = findViewById(R.id.et_lecture_date);
        EditText content = findViewById(R.id.et_lecture_content);
        TextView title = findViewById(R.id.tv_course_title);
        LectureRepository lectureRepository = new LectureRepository(this);
        CourseRepository courseRepository = new CourseRepository(this);

        Bundle extras = getIntent().getExtras();
        int course_id = extras.getInt("course_id");
        int lecture_id = extras.getInt("lecture_id");

        Course course = null;
        try {
            course = courseRepository.getCourseById(course_id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Lecture lecture = null;
        try {
            lecture = lectureRepository.getLectureById(lecture_id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        title.setText("General Course: " + course.getName());
        name.setText(lecture.getName());
        date.setText(lecture.getPlay_date());
        content.setText(lecture.getContent());

        Lecture finalLecture = lecture;
        Course finalCourse = course;
        save_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (name.getText().toString().isEmpty()) {
                    Toast.makeText(EditLectureActivity.this, "Lecture Name can't be empty!", Toast.LENGTH_SHORT).show();
                    return;
                }
                finalLecture.setName(name.getText().toString());
                finalLecture.setPlay_date(date.getText().toString());
                finalLecture.setContent(content.getText().toString());
                lectureRepository.updateLecture(finalLecture);
                Intent intent = new Intent(EditLectureActivity.this, ViewCourseDetail.class);
                intent.putExtra("course_name", finalCourse.getName());
                startActivity(intent);
            }
        });
        cancel_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EditLectureActivity.this, ViewCourseDetail.class);
                intent.putExtra("course_name",finalCourse.getName());
                startActivity(intent);
            }
        });
    }
}