package com.example.cmsmobile.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Submission {
    @PrimaryKey(autoGenerate = true)
    private int submisison_id;
    private String content;
//    private String files;
    private Float grade;
    private int account_id;
    private int exam_id;

    public int getSubmisison_id() {
        return submisison_id;
    }

    public void setSubmisison_id(int submisison_id) {
        this.submisison_id = submisison_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
