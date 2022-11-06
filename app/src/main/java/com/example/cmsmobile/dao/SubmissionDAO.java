package com.example.cmsmobile.dao;

import static androidx.room.OnConflictStrategy.REPLACE;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.RawQuery;
import androidx.room.Update;

import com.example.cmsmobile.entity.Lecture;
import com.example.cmsmobile.entity.Role;
import com.example.cmsmobile.entity.Submission;

import java.util.List;
import java.util.Optional;

@Dao
public interface SubmissionDAO {

    @Query("Select * From Submission")
    List<Submission> getAll();

    @Insert
    void insert(Submission... submissions);

    @Update
    void update(Submission submission);

    @Delete
    void delete(Submission submission);

    @Query("Select * from Submission where submission_id = :id ")
    Optional<Submission> findById(int id);
}
