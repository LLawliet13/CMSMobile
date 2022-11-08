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

public class EditExamActivity extends AppCompatActivity {

    private EditText etTitle, etDescription, etStartDate, etEndDate;
    private Button btn_Save, btn_Cancel;

    private ExamRepository examRepository;

    private Exam exam =null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_exam);

        initUI();

        examRepository = new ExamRepository(this);

        int exam_id = getIntent().getExtras().getInt("exam_id");

        exam = examRepository.getExamById(exam_id);
        if(exam==null){
            Toast.makeText(this, "Exam not exist", Toast.LENGTH_SHORT).show();
            return;
        }

        etTitle.setText(exam.getName());
        etDescription.setText(exam.getContent());
        etStartDate.setText(exam.getStart_date());
        etEndDate.setText(exam.getEnd_date());

        if(etTitle.getText().toString().isEmpty()){
            Toast.makeText(this, "Title can't be empty", Toast.LENGTH_SHORT).show();
            return;
        }

        btn_Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exam.setName(etTitle.getText().toString());
                exam.setContent(etDescription.getText().toString());
                exam.setStart_date(etStartDate.getText().toString());
                exam.setEnd_date(etEndDate.getText().toString());

                try{
                    examRepository.updateExam(exam);
                    Toast.makeText(v.getContext(), "Update thành công", Toast.LENGTH_SHORT).show();

                }catch(Exception ex){
                    Toast.makeText(v.getContext(), ex.getMessage(), Toast.LENGTH_SHORT).show();
                    return;
                }
                Intent intent = new Intent(v.getContext(), ViewExamActivity.class);
                int id = getIntent().getExtras().getInt("class_id");
                intent.putExtra("class_id", getIntent().getExtras().getInt("class_id"));
                startActivity(intent);
            }
        });

        btn_Cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void initUI() {
        etTitle = findViewById(R.id.etTitle);
        etDescription = findViewById(R.id.etDescription);
        etStartDate = findViewById(R.id.etStartDate);
        etEndDate = findViewById(R.id.etEndDate);
        btn_Save = findViewById(R.id.btn_save);
        btn_Cancel = findViewById(R.id.btn_cancel);
    }
}