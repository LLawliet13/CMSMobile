package com.example.cmsmobile.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.cmsmobile.R;
import com.example.cmsmobile.entity.Announcement;
import com.example.cmsmobile.entity.Course;

public class AnnouncementViewAdapter extends BaseAdapter {
    private Announcement[] announcementItem;
    private Activity activity;
    public AnnouncementViewAdapter(Activity activity, Announcement[] announcementItem){
        this.announcementItem = announcementItem;
        this.activity = activity;
    }
    @Override
    public int getCount() {
        return announcementItem.length;
    }

    @Override
    public Object getItem(int position) {
        return announcementItem[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = activity.getLayoutInflater();
        convertView = inflater.inflate(R.layout.announcement_view_item_activity,null);
            TextView textViewName = (TextView) convertView.findViewById(R.id.announcement_name);
            textViewName.setText(announcementItem[position].getName());
            TextView textViewAnnouncement = (TextView) convertView.findViewById(R.id.announcement_content);
            textViewAnnouncement.setText(announcementItem[position].getContent());
        return convertView;
    }
}
