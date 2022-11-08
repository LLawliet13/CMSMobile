package com.example.cmsmobile.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;

import com.example.cmsmobile.R;
import com.example.cmsmobile.activity.EditExamActivity;
import com.example.cmsmobile.activity.EditLectureActivity;
import com.example.cmsmobile.activity.ViewCourseDetail;
import com.example.cmsmobile.entity.Course;
import com.example.cmsmobile.entity.Lecture;
import com.example.cmsmobile.repository.CourseRepository;
import com.example.cmsmobile.repository.LectureRepository;

public class LectureAdapter extends BaseAdapter {
    private Lecture[] items;
    private Activity activity;
    public LectureAdapter(Activity activity,Lecture[] items){
        this.items = items;
        this.activity = activity;
    }
    @Override
    public int getCount() {
        return items.length;
    }

    @Override
    public Object getItem(int i) {
        return items[i];
    }

    @Override
    public long getItemId(int i) {
        return items[i].getLecture_id();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = activity.getLayoutInflater();
        convertView = inflater.inflate(R.layout.lecture_item,null);
        TextView textView = (TextView) convertView.findViewById(R.id.et_lecture_name_item);
        TextView tv_action = (TextView) convertView.findViewById(R.id.tv_action_lecture_item);
        Button btn_edit = (Button) convertView.findViewById(R.id.btn_edit_lecture_item);
        Button btn_remove = (Button) convertView.findViewById(R.id.btn_remove_lecture_item);

        textView.setText(items[position].getName());
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), items[position].getName(), Toast.LENGTH_SHORT).show();
            }
        });
        btn_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), EditLectureActivity.class);
                intent.putExtra("lecture_id", items[position].getLecture_id());
                intent.putExtra("course_id", items[position].getCourse_id());
                v.getContext().startActivity(intent);
            }
        });
        btn_remove.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                LectureRepository lectureRepository = new LectureRepository(v.getContext());
                CourseRepository courseRepository = new CourseRepository(v.getContext());
                lectureRepository.Remove(items[position]);
                Toast.makeText(v.getContext(), items[position].getName() + " removed", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(v.getContext(), ViewCourseDetail.class);
                try {
                    Course course = courseRepository.getCourseById(items[position].getCourse_id());
                    intent.putExtra("course_name", course.getName());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                v.getContext().startActivity(intent);
            }
        });

        String user_role = activity.getSharedPreferences("session", Context.MODE_PRIVATE).getString("role", "student");
        if (user_role.equals("student")){
            btn_remove.setVisibility(View.GONE);
            btn_edit.setVisibility(View.GONE);
        }

        return convertView;
    }
}
