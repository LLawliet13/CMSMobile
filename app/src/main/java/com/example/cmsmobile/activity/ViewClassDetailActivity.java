package com.example.cmsmobile.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.GridView;
import android.widget.TextView;

import com.example.cmsmobile.R;
import com.example.cmsmobile.adapter.ClassesViewAdapter;
import com.example.cmsmobile.entity.Classes;

import java.util.ArrayList;
import java.util.List;

public class ViewClassDetailActivity extends AppCompatActivity {

    private TextView tvCourseName, tvClassName, tvCourseRedirect;
    private RecyclerView rcvClassView;

    private ClassesViewAdapter classesViewAdapter;
    private List<Classes> listClasses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_class_detail);

        initUI();
        classesViewAdapter = new ClassesViewAdapter();
        listClasses =new ArrayList<>();
        classesViewAdapter.setData(listClasses);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcvClassView.setLayoutManager(linearLayoutManager);
        rcvClassView.setAdapter(classesViewAdapter);
    }

    private void initUI(){
        tvCourseName = findViewById(R.id.courseName);
        tvClassName = findViewById(R.id.className);
        tvCourseRedirect = findViewById(R.id.courseRedirect);
        rcvClassView = findViewById(R.id.rcvClassView);
    }
}