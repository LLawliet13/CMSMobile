package com.example.cmsmobile.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.cmsmobile.R;
import com.example.cmsmobile.entity.Course;
import com.example.cmsmobile.entity.Feedback;

public class FeedbackViewAdapter extends BaseAdapter {
    private Feedback[] feedbackItem;
    private Activity activity;
    public FeedbackViewAdapter(Activity activity, Feedback[] feedbackItem){
        this.feedbackItem = feedbackItem;
        this.activity = activity;
    }
    @Override
    public int getCount() {
        return feedbackItem.length;
    }

    @Override
    public Object getItem(int position) {
        return feedbackItem[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = activity.getLayoutInflater();
        convertView = inflater.inflate(R.layout.activity_view_course_feedback,null);
        TextView textViewId = (TextView) convertView.findViewById(R.id.courseIdView);
        textViewId.setText(feedbackItem[position].getCourse_id());
        TextView textViewContent = (TextView) convertView.findViewById(R.id.contentView);
        textViewContent.setText(feedbackItem[position].getContent());
        return convertView;
    }
}
