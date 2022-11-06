package com.example.cmsmobile.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.cmsmobile.entity.Classes;

import java.util.List;

@Dao
public interface ClassesDAO {

    @Insert
    void insert(Classes classes);

    @Update
    void updateClass(Classes classes);

    @Delete
    void delete(Classes classes);

    @Query("SELECT * FROM Classes WHERE id = :id")
    List<Classes> getAll();
}
