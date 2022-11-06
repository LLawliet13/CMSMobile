package com.example.cmsmobile.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.cmsmobile.entity.Course;
import com.example.cmsmobile.entity.Lecture;

import java.util.List;
import java.util.Optional;

@Dao
public interface LectureDAO {
    @Insert
    void insertLecture(Lecture lecture);

    @Insert
    void insertLecture(Lecture... lectures);

    @Update
    void updateLecture(Lecture lecture);

    @Delete
    void deleteLecture(Lecture lecture);

    @Query("Select * from Lecture")
    List<Lecture> getAllLecture();

    @Query("Select * from Lecture where name = :name ")
    Optional<Lecture> findByName(String name);

    @Query("Select * from Lecture where lecture_id = :id ")
    Optional<Lecture> findById(int id);
}