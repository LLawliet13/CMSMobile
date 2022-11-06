package com.example.cmsmobile.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cmsmobile.R;
import com.example.cmsmobile.entity.Course;
import com.example.cmsmobile.entity.Role;

import java.util.List;

public class CourseViewAdapter extends BaseAdapter {
    private Course[] courseItem;
    private Activity activity;
    public CourseViewAdapter(Activity activity, Course[] courseItem){
        this.courseItem = courseItem;
        this.activity = activity;
    }
    @Override
    public int getCount() {
        return courseItem.length;
    }

    @Override
    public Object getItem(int position) {
        return courseItem[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = activity.getLayoutInflater();
        convertView = inflater.inflate(R.layout.activity_search_course,null);
        TextView textView = (TextView) convertView.findViewById(R.id.CourseNameSearchView);
        textView.setText(courseItem[position].getName());
        return convertView;
    }
}
