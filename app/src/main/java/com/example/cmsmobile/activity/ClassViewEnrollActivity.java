package com.example.cmsmobile.activity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.cmsmobile.R;
import com.example.cmsmobile.entity.Account_Class;
import com.example.cmsmobile.repository.AccountRepository;
import com.example.cmsmobile.repository.Account_ClassRepository;
import com.example.cmsmobile.repository.ClassRepository;
import com.example.cmsmobile.repository.CourseRepository;

import java.util.Optional;

public class ClassViewEnrollActivity extends AppCompatActivity {

    ClassRepository classRepository;
    AccountRepository accountRepository;
    CourseRepository courseRepository;
    TextView className;
    TextView CourseName;
    TextView TeacherName;
    Account_ClassRepository account_classRepository;
    int class_id, course_id, account_id;
    Button enrollButton;
    String role_name;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_view_enroll);
        classRepository = new ClassRepository(this);
        account_classRepository = new Account_ClassRepository(this);
        accountRepository = new AccountRepository(this);
        courseRepository = new CourseRepository(this);

        className = findViewById(R.id.ClassName_Label_Class_ViewEnroll);
        CourseName = findViewById(R.id.CourseName_Label_Class_ViewEnroll);
        TeacherName = findViewById(R.id.Teacher_Label_Class_ViewEnroll);
        enrollButton = findViewById(R.id.enroll_classEnrolActivity);
        role_name = getSharedPreferences("session", Context.MODE_PRIVATE).getString("role", "");
        account_id = getSharedPreferences("session", Context.MODE_PRIVATE).getInt("account_id", 0);
        class_id = getIntent().getExtras().getInt("class_id");
        course_id = getIntent().getExtras().getInt("course_id");
        try {
            className.setText("Class Name: "+ classRepository.getClassById(class_id).getName());
            CourseName.setText("Course Name: "+courseRepository.getCourseById(course_id).getName());
            TeacherName.setText("Teacher Name: "+accountRepository.getAccountById(account_id).getUsername());
        } catch (Throwable e) {
            e.printStackTrace();
        }

        Optional<Account_Class> findExist = account_classRepository.getAllAccount_Class().stream().filter(
                ac -> ac.getClass_id() == class_id && ac.getAccount_id() == account_id).findAny();
        if (!findExist.isPresent()) {//fix cung de vao man 6
            Intent intent = new Intent(ClassViewEnrollActivity.this, ViewClassDetailActivity.class);
            intent.putExtra("class_id", class_id);
            startActivity(intent);
        }


        enrollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                account_classRepository.addAccount_Classes(new Account_Class(account_id, class_id));
                Intent intent = new Intent(ClassViewEnrollActivity.this, ViewClassDetailActivity.class);
                intent.putExtra("class_id", class_id);
                startActivity(intent);
            }
        });
        if (role_name == "student")
            enrollButton.setVisibility(View.VISIBLE);
        else
            enrollButton.setVisibility(View.GONE);
    }
}