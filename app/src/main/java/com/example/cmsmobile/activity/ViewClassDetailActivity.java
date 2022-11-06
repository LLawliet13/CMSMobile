package com.example.cmsmobile.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cmsmobile.R;
import com.example.cmsmobile.adapter.ClassesViewAdapter;
import com.example.cmsmobile.adapter.ExamViewAdapter;
import com.example.cmsmobile.entity.Classes;
import com.example.cmsmobile.entity.Exam;
import com.example.cmsmobile.repository.ClassRepository;
import com.example.cmsmobile.repository.ExamRepository;

import java.util.ArrayList;
import java.util.List;

public class ViewClassDetailActivity extends AppCompatActivity {

    private TextView tvCourseName, tvClassName, tvCourseRedirect;
    private RecyclerView rcvClassView;

    private ClassesViewAdapter classesViewAdapter;
    private ClassRepository classRepository;
    private List<Classes> listClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_class_detail);

        classRepository = new ClassRepository(this);

        initUI();

        classesViewAdapter = new ClassesViewAdapter();
        listClass = new ArrayList<>();
        classesViewAdapter.setData(listClass);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcvClassView.setLayoutManager(linearLayoutManager);
        rcvClassView.setAdapter(classesViewAdapter);
    }

    private void initUI(){
        tvCourseName = findViewById(R.id.courseName);
        tvClassName = findViewById(R.id.className);
        tvCourseRedirect = findViewById(R.id.courseRedirect);
    }
}