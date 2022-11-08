package com.example.cmsmobile.activity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cmsmobile.R;
import com.example.cmsmobile.entity.Classes;
import com.example.cmsmobile.entity.Course;
import com.example.cmsmobile.entity.Exam;
import com.example.cmsmobile.entity.Lecture;
import com.example.cmsmobile.entity.Submission;
import com.example.cmsmobile.repository.ClassRepository;
import com.example.cmsmobile.repository.CourseRepository;
import com.example.cmsmobile.repository.ExamRepository;
import com.example.cmsmobile.repository.SubmissionRepository;

public class ViewExamSubmissionActivity extends AppCompatActivity {

    Button btn_add_submission;
    Bundle extras;
    int exam_id, submission_id,class_id;
    TextView title, submission_title, submit_status, dual_date, dual_date_title;
    Exam exam;
    Classes classes;
    Submission submission;
    ExamRepository examRepository;
    SubmissionRepository submissionRepository;
    ClassRepository classRepository;
    CourseRepository courseRepository;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_exam_submission);

        title = findViewById(R.id.tv_submission_ex_title);
        submission_title = findViewById(R.id.tv_add_submit_title);
        submit_status = findViewById(R.id.tv_submit_status);
        dual_date = findViewById(R.id.tv_dual_date);
        dual_date_title = findViewById(R.id.tv_dual_date_title);
        btn_add_submission = findViewById(R.id.btn_add_submission);

        examRepository = new ExamRepository(this);
        classRepository = new ClassRepository(this);
        courseRepository = new CourseRepository(this);
        submissionRepository = new SubmissionRepository(this);

        extras = getIntent().getExtras();
//        class_id = extras.getInt("class_id");
//        exam_id = extras.getInt("exam_id");
        if (extras != null){
            submission_id = extras.getInt("submission_id");
        }

        classRepository.addClasses(new Classes("SE1511", "PRM392", "description", "attachments", 1));
        examRepository.addExam(new Exam("FE2011", "Content...", "12/12/2022", "13/12/2022", 1, 1));
        class_id = 1;
        exam_id = 1;
//        submission_id = 1;

        exam = examRepository.getExamById(exam_id);
        classes = new Classes();
        try {
            classes = classRepository.getClassById(class_id);
        } catch (Throwable e) {
            e.printStackTrace();
        }
        if (classes!=null){
            title.setText(classes.getName());
        }
        if (exam!=null){
            submission_title.setText("Exam submission: "+exam.getName());
        }
            try {
                submission = submissionRepository.getSubmissionById(submission_id);
            } catch (Exception e) {
                e.printStackTrace();
            }
        if (submission != null){
            dual_date.setVisibility(View.GONE);
            dual_date_title.setVisibility(View.GONE);
            btn_add_submission.setVisibility(View.GONE);
            submit_status.setText("Submitted");
        }

        btn_add_submission.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(ViewExamSubmissionActivity.this, AddExamSubmissionActivity.class);
                    intent.putExtra("class_id",class_id);
                    intent.putExtra("exam_id",exam_id);
                    startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}