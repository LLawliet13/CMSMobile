package com.example.cmsmobile.entity;

import androidx.annotation.Nullable;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Announcement {
    @PrimaryKey(autoGenerate = true)
    private int announcement_id;

    private String content;

    public Announcement() {
    }

    public int getAnnouncement_id() {
        return announcement_id;
    }

    public void setAnnouncement_id(int announcement_id) {
        this.announcement_id = announcement_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Nullable
    public String getFile() {
        return file;
    }

    public void setFile(@Nullable String file) {
        this.file = file;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Announcement(String content, String name) {
        this.content = content;
        this.name = name;
    }

    public Announcement(String content, @Nullable String file, String name, int account_id, int course_id) {
        this.content = content;
        this.file = file;
        this.name = name;
        this.account_id = account_id;
        this.course_id = course_id;
    }

    public Announcement(String content, @Nullable String file, String name) {
        this.content = content;
        this.file = file;
        this.name = name;
    }

    @Nullable
    private String file;

    private String name;
    private int account_id;
    private int course_id;
}
