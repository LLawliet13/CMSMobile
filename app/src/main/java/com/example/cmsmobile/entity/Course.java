package com.example.cmsmobile.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Course {
    @PrimaryKey(autoGenerate = true)
    private int course_id;

    private String name;
    private int creator_id;

    public Course(String name, int creator_id) {
        this.name = name;
        this.creator_id = creator_id;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCreator_id() {
        return creator_id;
    }

    public void setCreator_id(int creator_id) {
        this.creator_id = creator_id;
    }
}
