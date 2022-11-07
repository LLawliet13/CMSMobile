package com.example.cmsmobile.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.cmsmobile.R;
import com.example.cmsmobile.adapter.ExamViewAdapter;
import com.example.cmsmobile.entity.Exam;
import com.example.cmsmobile.repository.CourseRepository;
import com.example.cmsmobile.repository.ExamRepository;

import java.util.ArrayList;
import java.util.List;

public class ViewExamActivity extends AppCompatActivity {

    private TextView tvCourseName, tvClassName, tvCourseRedirect;
    private Button btnAdd;
    private RecyclerView rcvExamView;

    private ExamViewAdapter examViewAdapter;
    private ExamRepository examRepository;
    private CourseRepository courseRepository;
    private List<Exam> listExams;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_exam);

        initUI();
        examViewAdapter = new ExamViewAdapter();
        examRepository = new ExamRepository(this);
        courseRepository = new CourseRepository(this);

        int class_id = getIntent().getExtras().getInt("class_id");
        courseRepository.getCourseByClassId(class_id);

        listExams = examRepository.getExamsByCourseId(class_id);
        examViewAdapter.setData(listExams);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcvExamView.setLayoutManager(linearLayoutManager);
        rcvExamView.setAdapter(examViewAdapter);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addExam = new Intent(ViewExamActivity.this, AddExamActivity.class);
                startActivity(addExam);
            }
        });
    }

    private void initUI() {
        tvCourseName = findViewById(R.id.tvCourseName);
        tvClassName = findViewById(R.id.tvClassName);
        tvCourseRedirect = findViewById(R.id.tvClassRedirect);
        btnAdd = findViewById(R.id.btnAddAnnouncement);
        rcvExamView = findViewById(R.id.AnnouncementView);
    }
}