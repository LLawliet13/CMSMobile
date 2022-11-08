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

import com.example.cmsmobile.R;
import com.example.cmsmobile.entity.Classes;
import com.example.cmsmobile.entity.Exam;
import com.example.cmsmobile.entity.Submission;
import com.example.cmsmobile.repository.ClassRepository;
import com.example.cmsmobile.repository.CourseRepository;
import com.example.cmsmobile.repository.ExamRepository;
import com.example.cmsmobile.repository.SubmissionRepository;

public class AddExamSubmissionActivity extends AppCompatActivity {

    Button btn_add_submission;
    Bundle extras;
    int exam_id, submission_id,class_id;
    TextView title, submission_title;
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
        setContentView(R.layout.activity_add_exam_submission);

        title = findViewById(R.id.tv_add_submission_class);
        submission_title = findViewById(R.id.tv_add_submission_title);
        btn_add_submission = findViewById(R.id.btn_add_submission_save);

        examRepository = new ExamRepository(this);
        classRepository = new ClassRepository(this);
        courseRepository = new CourseRepository(this);
        submissionRepository = new SubmissionRepository(this);

//        classRepository.addClasses(new Classes("SE1511", "PRM392", "description", "attachments", 1));
//        examRepository.addExam(new Exam("FE2011", "Content...", "12/12/2022", "13/12/2022", 1, 1));
        class_id = 1;
        exam_id = 1;
        submission_id = 1;

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

        SaveSubmission();
        CancelSubmission();

        SubmissionRepository submissionRepository = new SubmissionRepository(this);
        Button add_btn = findViewById(R.id.btn_add_submission_save);
        add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText content = findViewById(R.id.et_submission_desc);
                submissionRepository.addSubmission(new Submission(content.getText().toString(), "",(float) 0,1,1));
                Submission new_submission = submissionRepository.getNewSubmission();
                Intent intent = new Intent(AddExamSubmissionActivity.this, ViewExamSubmissionActivity.class);
                intent.putExtra("class_id",class_id);
                intent.putExtra("exam_id",exam_id);
                intent.putExtra("submission_id", new_submission.getSubmission_id());
                startActivity(intent);
            }
        });
    }

    private void CancelSubmission() {

        Button cancel_btn = findViewById(R.id.btn_cancel_submission);
        cancel_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    Intent intent = new Intent(AddExamSubmissionActivity.this, ViewExamSubmissionActivity.class);
                    intent.putExtra("class_id",class_id);
                    intent.putExtra("exam_id",exam_id);
                    startActivity(intent);
            }
        });
    }

    private void SaveSubmission() {
    }
}