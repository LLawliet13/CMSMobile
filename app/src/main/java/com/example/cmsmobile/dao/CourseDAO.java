package com.example.cmsmobile.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.cmsmobile.entity.Course;

import java.util.List;
import java.util.Optional;

@Dao
public interface CourseDAO {
    @Insert
    void insertCourse(Course course);

    @Insert
    void insertCourse(Course... courses);

    @Update
    void updateCourse(Course Course);

    @Delete
    void deleteCourse(Course course);

    @Query("Select * from Course")
    List<Course> getAllCourse();

    @Query("Select * from Course where name= :name ")
    Optional<Course> findByName(String name);

    @Query("Select * from Course where course_id = :id ")
    Optional<Course> findById(int id);
}