package com.example.cmsmobile.activity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cmsmobile.R;
import com.example.cmsmobile.adapter.ClassesViewAdapter;
import com.example.cmsmobile.adapter.ExamViewAdapter;
import com.example.cmsmobile.entity.Classes;
import com.example.cmsmobile.entity.Course;
import com.example.cmsmobile.entity.Exam;
import com.example.cmsmobile.repository.ClassRepository;
import com.example.cmsmobile.repository.CourseRepository;
import com.example.cmsmobile.repository.ExamRepository;

import java.util.ArrayList;
import java.util.List;

public class ViewClassDetailActivity extends AppCompatActivity {

    private TextView tvCourseName, tvClassName, tvCourseRedirect;
    private Button btn_ViewClass;

    private ClassRepository classRepository;
    private CourseRepository courseRepository;

    private Classes classes = null;
    private Course course = null;


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_class_detail);

        classRepository = new ClassRepository(this);
        courseRepository = new CourseRepository(this);

        initUI();

//        int class_id = getIntent().getExtras().getInt("class_id");


        int class_id = 1;
        try {
            classes = classRepository.getClassById(class_id);
        } catch (Throwable e) {
            e.printStackTrace();
        }
        if(classes==null){
            return;
        }

        try {
            course = courseRepository.getCourseById(classes.getCourse_id());
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(course==null){
            return;
        }

        Toast.makeText(this, "Course Id "+classes.getCourse_id(), Toast.LENGTH_SHORT).show();


        tvCourseName.setText(course.getName());
        tvClassName.setText(classes.getName());
        tvCourseRedirect.setText(course.getName());

        btn_ViewClass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewClassDetailActivity.this, ViewExamActivity.class);
                intent.putExtra("class_id", classes.getClass_id());
                startActivity(intent);
            }
        });
    }

    private void initUI(){
        tvCourseName = findViewById(R.id.courseName);
        tvClassName = findViewById(R.id.className);
        tvCourseRedirect = findViewById(R.id.courseRedirect);
        btn_ViewClass = findViewById(R.id.btn_listExam);
    }
}