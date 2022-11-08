package com.example.cmsmobile.adapter;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.RequiresApi;

import com.example.cmsmobile.R;
import com.example.cmsmobile.activity.AddAnnouncementActivity;
import com.example.cmsmobile.activity.SearchCourseActivity;
import com.example.cmsmobile.activity.ViewClassDetailActivity;
import com.example.cmsmobile.activity.ViewGeneralCourseActivity;
import com.example.cmsmobile.entity.Course;

public class SearchAdapter extends BaseAdapter {
    private Course[] courseSearchItem;
    private Activity activity;
    public SearchAdapter(Activity activity, Course[] courseSearchItem){
        this.courseSearchItem = courseSearchItem;
        this.activity = activity;
    }
    @Override
    public int getCount() {
        return courseSearchItem.length;
    }

    @Override
    public Object getItem(int position) {
        return courseSearchItem[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public SearchAdapter() {
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = activity.getLayoutInflater();
        convertView = inflater.inflate(R.layout.activity_course_item_search_list,null);
        Button viewCourse, viewClass;
        if(position == 0){
            TextView textViewName = (TextView) convertView.findViewById(R.id.course_name);
            textViewName.setText("Name");
        }else{
            TextView textViewName = (TextView) convertView.findViewById(R.id.course_name);
            textViewName.setText(courseSearchItem[position].getName());
        }
        return convertView;
    }
    private Context context;

    public SearchAdapter(Context context) {
        this.context = context;
    }
}
