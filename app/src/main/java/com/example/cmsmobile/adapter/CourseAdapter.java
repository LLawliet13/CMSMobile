package com.example.cmsmobile.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.cmsmobile.R;
import com.example.cmsmobile.entity.Course;
import com.example.cmsmobile.entity.Role;

public class CourseAdapter extends BaseAdapter {
    private Course[] items;
    private Activity activity;
    public CourseAdapter(Activity activity,Course[] items){
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
        return items[i].getCourse_id();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = activity.getLayoutInflater();
        convertView = inflater.inflate(R.layout.course_item,null);
        TextView textView = (TextView) convertView.findViewById(R.id.txt_course_name);
        textView.setText(items[position].getName());
        return convertView;
    }
}
