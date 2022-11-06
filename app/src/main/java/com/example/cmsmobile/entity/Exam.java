package com.example.cmsmobile.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Exam {

    @PrimaryKey(autoGenerate = true)
    private int exam_id;

    private String name;

    private String content;

    private String file;

    private int course_id;

    private int lecture_id;

    public Exam() {
    }

    public Exam(int exam_id, String name, String content, String file, int course_id, int lecture_id) {
        this.exam_id = exam_id;
        this.name = name;
        this.content = content;
        this.file = file;
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

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
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
