package com.example.cmsmobile.repository;

import android.content.Context;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.cmsmobile.dao.AccountDAO;
import com.example.cmsmobile.dao.FeedbackDAO;
import com.example.cmsmobile.entity.Account;
import com.example.cmsmobile.entity.CMSDatabase;
import com.example.cmsmobile.entity.Feedback;

import java.util.ArrayList;
import java.util.List;

public class FeedbackRepository {
    private FeedbackDAO feedbackDAO;

    public FeedbackRepository(Context context) {
        feedbackDAO = CMSDatabase.getInstance(context).feedbackDAO();
    }

    public FeedbackDAO getFeedbackDAO() {
        return feedbackDAO;
    }

    public void addFeedback(Feedback feedback){
        feedbackDAO.insert(feedback);
    }
    public List<Feedback> getAllFeedback(){
        List<Feedback> feedbackList = new ArrayList<>();
        feedbackList.addAll(feedbackDAO.getAll());
        return feedbackList;
    }
}
