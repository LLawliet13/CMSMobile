package com.example.cmsmobile.entity;

import androidx.room.PrimaryKey;

public class Feedback {
    @PrimaryKey(autoGenerate = true)
    public int feedback_id;
    public String content;
    private int account_id;
    private int course_id;

    public Feedback(int feedback_id, String content, int account_id, int course_id) {
        this.feedback_id = feedback_id;
        this.content = content;
        this.account_id = account_id;
        this.course_id = course_id;
    }

    public Feedback(int feedback_id, String content) {
        this.feedback_id = feedback_id;
        this.content = content;
    }

    public int getFeedback_id() {
        return feedback_id;
    }

    public void setFeedback_id(int feedback_id) {
        this.feedback_id = feedback_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public Feedback() {
    }
}
