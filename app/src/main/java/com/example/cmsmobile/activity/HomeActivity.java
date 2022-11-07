package com.example.cmsmobile.activity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.cmsmobile.R;

import com.example.cmsmobile.entity.Account;
import com.example.cmsmobile.entity.Account_Class;
import com.example.cmsmobile.entity.Classes;
import com.example.cmsmobile.entity.Course;
import com.example.cmsmobile.repository.AccountRepository;
import com.example.cmsmobile.repository.Account_ClassRepository;
import com.example.cmsmobile.repository.ClassRepository;
import com.example.cmsmobile.repository.CourseRepository;
import com.example.cmsmobile.repository.RoleRepository;

public class HomeActivity extends AppCompatActivity {
    TextView accountName;
    Button login_button;
    Button joinNow_button;
    Button logoutButton;
    Button annBtn;
    Button profileBtn;
    RoleRepository roleRepository;
    AccountRepository accountRepository;
    ClassRepository classRepository;
    CourseRepository courseRepository;
    Account_ClassRepository account_classRepository;


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        roleRepository = new RoleRepository(this);
        accountRepository = new AccountRepository(this);
        courseRepository = new CourseRepository(this);
        classRepository = new ClassRepository(this);
        account_classRepository = new Account_ClassRepository(this);

        if (roleRepository.getAllRoles().size() == 0){
            roleRepository.setUpRoles();
            if(accountRepository.getAllAccounts().size() == 0)
                accountRepository.addAccount(new Account("sangnv@fpt.edu.vn","123456","Nguyen Van Sang","Ha noi","0123456789",2));

            if(courseRepository.getAllCourses().size() ==0)
                courseRepository.addCourse(new Course("PRM392"));
            if(classRepository.getAllClasses().size()==0){
                classRepository.addClasses(new Classes("se1515",courseRepository.getCourseByName("PRM392").get(0).getName(),"Android Class","abc/cde",courseRepository.getCourseByName("PRM392").get(0).getCourse_id()));
            }
            if(account_classRepository.getAllAccount_Class().size()==0){
                try {
                    account_classRepository.addAccount_Classes(new Account_Class(accountRepository.getAccountByEmail("sangnv@fpt.edu.vn").getAccount_id(),classRepository.getClassByName("PRM392").getClass_id()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        AccountRepository accountRepository = new AccountRepository(this);
        Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
        accountName = findViewById(R.id.accountName);
        String name = getIntent().getStringExtra("name");
        accountName.setText(name);
        login_button = findViewById(R.id.LoginBtnForHome);
        joinNow_button = findViewById(R.id.JoinNowButtonForHome);
        logoutButton = findViewById(R.id.logoutBtnHome);
        annBtn = findViewById(R.id.viewAnnouncementBtn);
        profileBtn= findViewById(R.id.accountBtn);
        //gan logoutButton

        if (getSharedPreferences("session", Context.MODE_PRIVATE).getInt("account_id", 0) > 0) {
            login_button.setVisibility(View.GONE);
            joinNow_button.setVisibility(View.GONE);
            logoutButton.setVisibility(View.VISIBLE);
            annBtn.setVisibility(View.VISIBLE);
            profileBtn.setVisibility(View.VISIBLE);

        } else {
            login_button.setVisibility(View.VISIBLE);
            joinNow_button.setVisibility(View.VISIBLE);
            logoutButton.setVisibility(View.GONE);
            annBtn.setVisibility(View.GONE);
            profileBtn.setVisibility(View.GONE);
        }
    }

    public void onLogoutView(View view) {
        SharedPreferences pref = getApplicationContext().getSharedPreferences("session", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.remove("account_id");
        editor.commit();
        editor.clear();
        editor.commit();
        Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
        startActivity(intent);
    }

    public void onLoginView(View view) {
        Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
        try {
            startActivity(intent);
        } catch (ActivityNotFoundException e) {
            sendBroadcast(intent);
        }

    }

    public void onAnnouncementView(View view) {
        Intent intent = new Intent(HomeActivity.this, ViewAnnouncementActivity.class);
        try {
            startActivity(intent);
        } catch (ActivityNotFoundException e) {
            sendBroadcast(intent);
        }

    }
    public void ProfileView(View view) {
        SharedPreferences pref = getApplicationContext().getSharedPreferences("session", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        Intent intent = new Intent(HomeActivity.this, UpdateProfileActivity.class);
        try {
            if( getSharedPreferences("session", Context.MODE_PRIVATE).getInt("account_id", 0) > 0)
            startActivity(intent);
        } catch (ActivityNotFoundException e) {
            sendBroadcast(intent);
        }
    }
    public void SearchView(View view) {
        Intent intent = new Intent(HomeActivity.this, SearchCourseActivity.class);
        try {
            startActivity(intent);
        } catch (ActivityNotFoundException e) {
            sendBroadcast(intent);
        }
    }
}