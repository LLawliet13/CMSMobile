package com.example.cmsmobile.dao;

import androidx.room.Dao;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import com.example.cmsmobile.entity.Classes;
import java.util.List;
import java.util.Optional;

@Dao
public interface ClassesDAO {

    @Insert
    void insert(Classes classes);

    @Update
    void updateClass(Classes classes);

    @Delete
    void delete(Classes classes);

    @Query("SELECT * FROM Classes")
    List<Classes> getAll();

    @Query("SELECT * FROM Classes WHERE class_id = :id")
    Optional<Classes> findById(int id);


    @Query("SELECT * FROM Classes WHERE name = :name")
    Classes findClassByName(String name);
}
