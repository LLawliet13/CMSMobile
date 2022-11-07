package com.example.cmsmobile.activity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.cmsmobile.R;
import com.example.cmsmobile.adapter.CourseViewAdapter;
import com.example.cmsmobile.adapter.SearchAdapter;
import com.example.cmsmobile.entity.Course;
import com.example.cmsmobile.entity.Role;
import com.example.cmsmobile.repository.CourseRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SearchCourseActivity extends AppCompatActivity {
    EditText searchTxt;
    Button search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_course);
        CourseRepository courseRepository = new CourseRepository(this);
        searchTxt = findViewById(R.id.searchTxt);
        search = findViewById(R.id.searchBtn);
        ListView courseListView = (ListView) findViewById(R.id.search_list);
        List<Course> courses = new ArrayList<>();
        search.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                String searchName = searchTxt.getText().toString();
                List<Course> course = courseRepository.getCourseByName(searchName);
                courses.addAll(courseRepository.getAllCourses());
                courses.addAll(courseRepository.getCourseByName(searchName));
                courses.add(0, new Course());

                SearchAdapter adapter = new SearchAdapter(SearchCourseActivity.this,courses.stream().toArray(Course[]::new));
                courseListView.setAdapter(adapter);
                if (courses.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "No contain", Toast.LENGTH_LONG).show();

                } else {
                    Intent intent = new Intent(SearchCourseActivity.this, SearchCourseActivity.class);
                    startActivity(intent);

                }
            }
        });
        courseListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                Course selectedItem = (Course) parent.getItemAtPosition(position);
                Toast.makeText(view.getContext(), selectedItem.getName(), Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(), ViewGeneralCourseActivity.class);
                intent.putExtra("course_id", selectedItem.getCourse_id() + "");
                intent.putExtra("name", selectedItem.getName());
//                intent.putExtra("price",selectedItem.getPrice()+"");

                startActivity(intent);

            }
        });
    }
}
