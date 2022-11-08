package com.example.cmsmobile.activity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.widget.ListView;

import com.example.cmsmobile.R;
import com.example.cmsmobile.adapter.AnnouncementViewAdapter;
import com.example.cmsmobile.adapter.FeedbackViewAdapter;
import com.example.cmsmobile.entity.Announcement;
import com.example.cmsmobile.entity.Feedback;
import com.example.cmsmobile.repository.AnnouncementRepository;
import com.example.cmsmobile.repository.FeedbackRepository;

import java.util.ArrayList;
import java.util.List;

public class ViewCourseFeedbackActivity extends AppCompatActivity {
FeedbackRepository feedbackRepository;
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_course_feedback);
        feedbackRepository = new FeedbackRepository(this);
        ListView feedbackListView = (ListView) findViewById(R.id.list_feedback);
        List<Feedback> feedbacks = new ArrayList<>();
        feedbacks.addAll(feedbackRepository.getAllFeedback());
        feedbacks.add(0, new Feedback());
        FeedbackViewAdapter adapter = new FeedbackViewAdapter(ViewCourseFeedbackActivity.this,feedbacks.stream().toArray(Feedback[]::new));
        feedbackListView.setAdapter(adapter);
    }
}