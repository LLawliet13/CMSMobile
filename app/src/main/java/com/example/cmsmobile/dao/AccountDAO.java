package com.example.cmsmobile.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.cmsmobile.entity.Account;

import java.util.List;
import java.util.Optional;

@Dao
public interface AccountDAO {
    @Insert
    void insert(Account account);

    @Insert
    void insert(Account... accounts);

    @Update
    void updateAccount(Account account);

    @Delete
    void delete(Account account);

    @Query("Select * from Account ")
    List<Account> getAll();

    @Query("Select * from Account where account_id = :id ")
    Optional<Account> findById(int id);

    @Query("Select * from Account where email like :mail")
    List<Account> findByEmail(String mail);
}