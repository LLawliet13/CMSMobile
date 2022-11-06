package com.example.cmsmobile.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Submission {
    @PrimaryKey(autoGenerate = true)
    private int submission_id;
    private String content;
    private String files;
    private Float grade;
    private int account_id;
    private int exam_id;

//    public Submission(int submission_id) {
//        this.submission_id = submission_id;
//    }
//
//    public Submission(int submission_id, String content, String files, Float grade, int account_id, int exam_id) {
//        this.submission_id = submission_id;
//        this.content = content;
//        this.files = files;
//        this.grade = grade;
//        this.account_id = account_id;
//        this.exam_id = exam_id;
//    }

    public int getSubmission_id() {
        return submission_id;
    }

    public void setSubmission_id(int submission_id) {
        this.submission_id = submission_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFiles() {
        return files;
    }

    public void setFiles(String files) {
        this.files = files;
    }

    public Float getGrade() {
        return grade;
    }

    public void setGrade(Float grade) {
        this.grade = grade;
    }

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    public int getExam_id() {
        return exam_id;
    }

    public void setExam_id(int exam_id) {
        this.exam_id = exam_id;
    }
}
