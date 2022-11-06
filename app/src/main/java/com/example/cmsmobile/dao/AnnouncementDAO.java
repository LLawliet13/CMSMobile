package com.example.cmsmobile.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.cmsmobile.entity.Announcement;
import com.example.cmsmobile.entity.Course;

import java.util.List;

@Dao
public interface AnnouncementDAO {
    @Insert
    void insert(Announcement announcement);

    @Insert
    void insert(Announcement... announcement);

    @Update
    void update(Announcement announcement);

    @Delete
    void delete(Announcement announcement);
    @Query("Select * from Announcement")
    List<Announcement> getAllAnnouncement();
}
