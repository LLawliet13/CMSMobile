package com.example.cmsmobile.dao;

import static androidx.room.OnConflictStrategy.REPLACE;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.RawQuery;

import com.example.cmsmobile.entity.Submission;

import java.util.List;

@Dao
public interface SubmissionDAO {
    @Insert(onConflict = REPLACE)
    abstract void insert(Submission submission);

    @Query("Select * From Submission")
    List<Submission> getAll();

    @Query("Update Submission Set content = :content, grade = :grade Where submission_id = :submission_id")
    void update(int submission_id, String content, Float grade, int account_id, int exam_id );

    @Delete
    void delete(Submission submission);
}
