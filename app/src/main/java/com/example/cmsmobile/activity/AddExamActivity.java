package com.example.cmsmobile.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cmsmobile.R;
import com.example.cmsmobile.entity.Exam;
import com.example.cmsmobile.repository.ExamRepository;

import java.util.Date;
import java.util.regex.Matcher;

public class AddExamActivity extends AppCompatActivity {

    private EditText etExamTitle, etClassDescription, etStartDate, etEndDate;
    private Button btnSave, btnCancel;

    private ExamRepository examRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_exam);
        initUI();
        examRepository = new ExamRepository(this);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int course_id = getIntent().getExtras().getInt("course_id");
                String examTitle = etExamTitle.getText().toString().trim();
                String description = etClassDescription.getText().toString().trim();
                String startDate = etStartDate.getText().toString().trim();
                String endDate = etEndDate.getText().toString().trim();
                Exam exam = ValidationExam(examTitle, description, startDate, endDate, course_id);
                examRepository.addExam(exam);
                Toast.makeText(AddExamActivity.this, "Add exam successfully!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(AddExamActivity.this, ViewExamActivity.class);
                startActivity(intent);
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddExamActivity.this, ViewExamActivity.class);
                intent.putExtra("class_id", getIntent().getExtras().getInt("class_id"));
                startActivity(intent);
            }
        });
    }

    public void initUI(){
        etExamTitle = findViewById(R.id.examTitle);
        etClassDescription = findViewById(R.id.classDescription);
        etStartDate = findViewById(R.id.startDate);
        etEndDate = findViewById(R.id.endDate);
        btnSave = findViewById(R.id.btnSave);
        btnCancel = findViewById(R.id.btnCancel);
    }

    public Exam ValidationExam(String examTitle, String description, String startDate, String endDate, int course_id){
        if(examTitle.isEmpty()){
            Toast.makeText(AddExamActivity.this, "Exam title is required!", Toast.LENGTH_SHORT).show();
            return null;
        }
        if(!startDate.isEmpty()){
            if(!startDate.matches("^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$")){
                Toast.makeText(AddExamActivity.this, "Start date wrong format!", Toast.LENGTH_SHORT).show();
                return null;

            }
        }

        if(!endDate.isEmpty()){
            if(!endDate.matches("^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$")){
                Toast.makeText(AddExamActivity.this, "End date wrong format!", Toast.LENGTH_SHORT).show();
                return null;
            }

            if(startDate.compareTo(endDate)>=0){
                Toast.makeText(AddExamActivity.this, "End date must larger than start date!", Toast.LENGTH_SHORT).show();
                return null;
            }
        }

        Exam exam = new Exam(examTitle, description, startDate, endDate, course_id, 0);
        return exam;
    }
}