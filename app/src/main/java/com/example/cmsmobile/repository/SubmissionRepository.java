package com.example.cmsmobile.repository;

import android.content.Context;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.cmsmobile.dao.LectureDAO;
import com.example.cmsmobile.dao.SubmissionDAO;
import com.example.cmsmobile.entity.CMSDatabase;
import com.example.cmsmobile.entity.Lecture;
import com.example.cmsmobile.entity.Submission;

import java.util.List;

public class SubmissionRepository {
    private SubmissionDAO submissionDAO;

    public SubmissionRepository(Context context) {
        submissionDAO = CMSDatabase.getInstance(context).submissionDAO();
    }

    public SubmissionDAO getSubmissionDAO() {
        return submissionDAO;
    }

    public void addSubmission(Submission submission){
        submissionDAO.insert(submission);
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    public Submission getSubmissionById(int id) throws Exception {
        return submissionDAO.findById(id).orElseThrow(()->
                new Exception("No Lecture Found")
        );
    }
    public List<Submission> getAllSubmissions(){
        return submissionDAO.getAll();
    }
    public void updateSubmission(Submission submission){
        submissionDAO.update(submission);
    }
}
