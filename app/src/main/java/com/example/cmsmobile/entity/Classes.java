package com.example.cmsmobile.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Classes {
    @PrimaryKey(autoGenerate = true)
    private int class_id;

    private String name;
    private String description;
    private String attachments;
    private int course_id;

    public Classes() {
    }

    public int getClass_id() {
        return class_id;
    }

    public void setClass_id(int id) {
        this.class_id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAttachments() {
        return attachments;
    }

    public void setAttachments(String attachments) {
        this.attachments = attachments;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }
}
