package com.example.cmsmobile.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Exam {

    @PrimaryKey(autoGenerate = true)
    private int exam_id;

    private String name;

    private String content;

    private String start_date;

    private String end_date;

    private int course_id;

    private int lecture_id;


    public Exam() {
    }

    public Exam(int exam_id, String name, String content, String start_date, String end_date, int course_id, int lecture_id) {
        this.exam_id = exam_id;
        this.name = name;
        this.content = content;
        this.start_date = start_date;
        this.end_date = end_date;
        this.course_id = course_id;
        this.lecture_id = lecture_id;
    }

    public Exam(String name, String content, String start_date, String end_date, int course_id, int lecture_id) {
        this.name = name;
        this.content = content;
        this.start_date = start_date;
        this.end_date = end_date;
        this.course_id = course_id;
        this.lecture_id = lecture_id;
    }

    public int getExam_id() {
        return exam_id;
    }

    public void setExam_id(int exam_id) {
        this.exam_id = exam_id;
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

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public int getLecture_id() {
        return lecture_id;
    }

    public void setLecture_id(int lecture_id) {
        this.lecture_id = lecture_id;
    }
}
