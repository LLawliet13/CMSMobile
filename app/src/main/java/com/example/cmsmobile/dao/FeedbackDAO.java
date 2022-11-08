package com.example.cmsmobile.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.cmsmobile.entity.Account;
import com.example.cmsmobile.entity.Feedback;

import java.util.List;

@Dao
public interface FeedbackDAO {
    @Insert
    void insert(Feedback feedback);

    @Insert
    void insert(Feedback... feedbacks);

    @Update
    void updateAccount(Feedback feedback);

    @Delete
    void delete(Feedback feedback);

    @Query("Select * from Feedback ")
    List<Feedback> getAll();
}
