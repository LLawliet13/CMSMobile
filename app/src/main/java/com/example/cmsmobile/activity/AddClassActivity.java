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
import com.example.cmsmobile.entity.Course;
import com.example.cmsmobile.repository.ClassRepository;
import com.example.cmsmobile.repository.CourseRepository;

public class AddClassActivity extends AppCompatActivity {

    private EditText etClassName, etSubjectCode, etTeacher, etDescription;
    private Button btnSave, btnCancel;

    private ClassRepository classRepository;
    private CourseRepository courseRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_class);

        initUI();
        classRepository = new ClassRepository(this);
        courseRepository = new CourseRepository(this);

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddClassActivity.this, ClassListActivity.class);
                startActivity(intent);
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                int course_id = getIntent().getExtras().getInt("course_id");
                Course course = null;
                try {
                    course = courseRepository.getCourseById(course_id);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if(course==null){
                    return;
                }

                String className = etClassName.getText().toString();
                String subjectCode = etSubjectCode.getText().toString();
                String teacher = etTeacher.getText().toString();
                String description = etDescription.getText().toString();
                if (className.isEmpty()) {
                    Toast.makeText(AddClassActivity.this, "Class Name can't be empty!", Toast.LENGTH_SHORT).show();
                    return;
                }
                Classes classes = new Classes(className, subjectCode, description, teacher, 1);
                if(classes==null){
                    Toast.makeText(AddClassActivity.this, "Class can't be found!", Toast.LENGTH_SHORT).show();
                    return;
                }
                classRepository.addClasses(classes);

                Intent intent = new Intent(AddClassActivity.this, ClassListActivity.class);
                intent.putExtra("course_id", course_id);
                startActivity(intent);
            }
        });
    }

    public void initUI() {
        etClassName = findViewById(R.id.etClassName);
        etSubjectCode = findViewById(R.id.etSubjectCode);
        etTeacher = findViewById(R.id.etTeacher);
        etDescription = findViewById(R.id.etDescription);
        btnSave = findViewById(R.id.btnSave);
        btnCancel = findViewById(R.id.btnCancel);
    }
}