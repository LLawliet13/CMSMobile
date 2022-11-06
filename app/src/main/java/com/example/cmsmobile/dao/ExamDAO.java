package com.example.cmsmobile.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.cmsmobile.entity.Exam;

import java.util.List;
import java.util.Optional;

@Dao
public interface ExamDAO {

    @Insert
    void insert(Exam exam);

    @Update
    void updateExam(Exam exam);

    @Delete
    void delete(Exam exam);

    @Query("SELECT * FROM Exam")
    List<Exam> getAll();

    @Query("SELECT * FROM Exam WHERE exam_id = :id")
    Optional<Exam> findById(int id);

    @Query("SELECT * FROM Exam WHERE course_id=:id")
    List<Exam> findExamsByCourseId(int id);
}
