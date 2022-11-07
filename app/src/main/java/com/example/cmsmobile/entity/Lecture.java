package com.example.cmsmobile.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity
public class Lecture {
    @PrimaryKey(autoGenerate = true)
    private int lecture_id;

    private String name;
    private String content;
    private int course_id;
    private String play_date;

    public Lecture(String name, String content, int course_id, String play_date) {
        this.name = name;
        this.content = content;
        this.course_id = course_id;
        this.play_date = play_date;
    }

    public int getLecture_id() {
        return lecture_id;
    }

    public void setLecture_id(int lecture_id) {
        this.lecture_id = lecture_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public String getPlay_date() {
        return play_date;
    }

    public void setPlay_date(String play_date) {
        this.play_date = play_date;
    }
}
