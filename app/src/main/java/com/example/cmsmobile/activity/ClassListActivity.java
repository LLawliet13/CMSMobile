package com.example.cmsmobile.activity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.cmsmobile.R;
import com.example.cmsmobile.adapter.ClassListActivityAdapter;
import com.example.cmsmobile.adapter.RoleAdapter;
import com.example.cmsmobile.entity.Account_Class;
import com.example.cmsmobile.entity.Classes;
import com.example.cmsmobile.entity.Role;
import com.example.cmsmobile.repository.AccountRepository;
import com.example.cmsmobile.repository.Account_ClassRepository;
import com.example.cmsmobile.repository.ClassRepository;

import java.util.List;
import java.util.stream.Collectors;

public class ClassListActivity extends AppCompatActivity {

    int account_id;
    String role;
    int courseId;

    ClassRepository classRepository;
    AccountRepository accountRepository;
    Account_ClassRepository account_classRepository;
    List<Account_Class> account_classList;
    Button addAClassButton;
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_list);
        classRepository = new ClassRepository(this);
        accountRepository = new AccountRepository(this);
        account_classRepository = new Account_ClassRepository(this);

        addAClassButton = findViewById(R.id.add_class_classListActivity_button);

//        account_classRepository = new Account_ClassRepository(this);
//        account_id = getApplicationContext().getSharedPreferences("session", Context.MODE_PRIVATE).getInt("account_id", 0);
//        if (account_id > 0) {
        account_id = getApplicationContext().getSharedPreferences("session", Context.MODE_PRIVATE).getInt("account_id", 0);
        role = getApplicationContext().getSharedPreferences("session", Context.MODE_PRIVATE).getString("role", "");
//        courseId = getIntent().getExtras().getInt("course_id");//fake
        courseId = 1;
        if (role.equals("teacher")) {
            account_classList = account_classRepository.findClassesOfATeacher(account_id);

            addAClassButton.setVisibility(View.VISIBLE);
        } else {
            addAClassButton.setVisibility(View.GONE);
        }
        addAClassButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ClassListActivity.this, AddClassActivity.class);
                startActivity(intent);
            }

        });
        List<Classes> classesChoosed  = classRepository.getAllClassesList().stream().filter(c -> c.getCourse_id() == courseId).collect(Collectors.toList());
        classesChoosed.add(0,new Classes());
        Classes[] classes = classesChoosed.stream().toArray(Classes[]::new);

        ListView classList = (ListView) findViewById(R.id.classList_classListActivity);
        ClassListActivityAdapter adapter = new ClassListActivityAdapter(classes, this
                , role,account_id, accountRepository.getAllAccounts(), account_classRepository.getAllAccount_Class(), this,courseId );
        classList.setAdapter(adapter);
        classList.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0) return;
                int class_id = classes[position-1].getClass_id();

                Intent intent = new Intent(ClassListActivity.this,ViewClassDetailActivity.class);
                intent.putExtra("class_id",class_id);
                intent.putExtra("course_id",class_id);
                //based on item add info to intent
                startActivity(intent);
            }


        });



    }
}