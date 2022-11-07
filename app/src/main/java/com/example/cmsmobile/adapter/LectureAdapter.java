package com.example.cmsmobile.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cmsmobile.R;
import com.example.cmsmobile.entity.Course;
import com.example.cmsmobile.entity.Lecture;

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
                Toast.makeText(v.getContext(), "edit"+items[position].getName(), Toast.LENGTH_SHORT).show();
            }
        });
        btn_remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "remove" +items[position].getName(), Toast.LENGTH_SHORT).show();
            }
        });

        return convertView;
    }
}
