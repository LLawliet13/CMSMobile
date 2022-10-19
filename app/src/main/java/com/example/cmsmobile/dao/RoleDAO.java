package com.example.cmsmobile.dao;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.cmsmobile.entity.Role;

import java.util.List;
import java.util.Optional;

@Dao
public interface RoleDAO {
    @Insert
    void insert(Role role);

    @Insert
    void insert(Role... roles);

    @Update
    void updateRole(Role role);

    @Delete
    void delete(Role role);

    @Query("Select * from Role ")
    List<Role> getAll();

    @Query("Select * from Role where role_id = :id ")
    Optional<Role> findById(int id);

    @Query("Select * from Role where name like :name")
    List<Role> findByName(String name);
}
