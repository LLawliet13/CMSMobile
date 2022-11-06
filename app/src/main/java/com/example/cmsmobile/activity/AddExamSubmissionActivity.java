package com.example.cmsmobile.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.cmsmobile.R;
import com.example.cmsmobile.entity.Submission;
import com.example.cmsmobile.repository.SubmissionRepository;

public class AddExamSubmissionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_exam_submission);

        SaveSubmission();
        CancelSubmission();
    }

    private void CancelSubmission() {
        EditText content = findViewById(R.id.et_submission_desc);
        SubmissionRepository submissionRepository = new SubmissionRepository(this);
        Button cancel_btn = findViewById(R.id.btn_cancel_submission);
        cancel_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    submissionRepository.addSubmission(new Submission(content.getText().toString(), "",(float) 0,1,1));
                    Intent intent = new Intent(AddExamSubmissionActivity.this, ViewExamSubmissionActivity.class);
                    startActivity(intent);
            }
        });
    }

    private void SaveSubmission() {
        Button add_btn = findViewById(R.id.btn_add_submission);
        add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Intent intent = new Intent(AddExamSubmissionActivity.this, ViewExamSubmissionActivity.class);
                    startActivity(intent);
            }
        });
    }
}