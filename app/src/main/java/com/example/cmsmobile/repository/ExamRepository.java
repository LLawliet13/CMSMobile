package com.example.cmsmobile.repository;

import android.content.Context;

import com.example.cmsmobile.dao.ExamDAO;
import com.example.cmsmobile.entity.CMSDatabase;
import com.example.cmsmobile.entity.Exam;

import java.util.List;

public class ExamRepository {

    private ExamDAO examDAO;

    public ExamRepository(Context context) {
        examDAO = CMSDatabase.getInstance(context).examDAO();
    }

    public ExamDAO getExamDAO() {
        return examDAO;
    }

    public void addExam(Exam exam) {
        examDAO.insert(exam);
    }

    public List<Exam> getAllExam() {
        return examDAO.getAll();
    }

    public void updateExam(Exam exam) {
        examDAO.updateExam(exam);
    }

    public void removeExam(Exam exam) {
        examDAO.delete(exam);
    }

    public List<Exam> getExamsByClassId(int id){
        return examDAO.findExamsByClassId(id);
    }
}
