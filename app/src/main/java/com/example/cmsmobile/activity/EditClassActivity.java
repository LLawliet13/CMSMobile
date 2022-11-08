package com.example.cmsmobile.activity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cmsmobile.R;
import com.example.cmsmobile.entity.Classes;
import com.example.cmsmobile.repository.ClassRepository;
import com.example.cmsmobile.repository.CourseRepository;

public class EditClassActivity extends AppCompatActivity {

    private EditText etClassName, etSubjectCode, etTeacher, etDescription;
    private Button btn_save, btn_cancel;

    private ClassRepository classRepository;
    private CourseRepository courseRepository;

    private Classes classes = null;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_class);

        initUI();

        classRepository = new ClassRepository(this);
        courseRepository = new CourseRepository(this);

//        int class_id = getIntent().getExtras().getInt("class_id");

        int class_id = 1;

        try {
            classes = classRepository.getClassById(class_id);
        } catch (Throwable e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
            return;
        }

        if (classes == null) return;

        etClassName.setText(classes.getName());
        etSubjectCode.setText(classes.getSubject_code());
        etDescription.setText(classes.getDescription());

        if(etClassName.getText().toString().isEmpty()){
            Toast.makeText(this, "Class Name can't be empty", Toast.LENGTH_SHORT).show();
            return;
        }

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                classes.setName(etClassName.getText().toString().trim());
                classes.setSubject_code(etSubjectCode.getText().toString().trim());
                classes.setDescription(etDescription.getText().toString().trim());

                try{
                    classRepository.updateClasses(classes);
                    Toast.makeText(v.getContext(), "Update thành công", Toast.LENGTH_SHORT).show();
                }catch (Exception ex){
                    Toast.makeText(v.getContext(), ex.getMessage(), Toast.LENGTH_SHORT).show();
                    return;
                }

                Intent intent = new Intent(v.getContext(), ViewClassDetailActivity.class);
                intent.putExtra("class_id", classes.getClass_id());
                startActivity(intent);
            }
        });

        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void initUI() {
        etClassName = findViewById(R.id.etClassName);
        etSubjectCode = findViewById(R.id.etSubjectCode);
        etTeacher = findViewById(R.id.etTeacher);
        etDescription = findViewById(R.id.etDescription);
        btn_save = findViewById(R.id.btn_save);
        btn_cancel = findViewById(R.id.btn_cancel);
    }
}