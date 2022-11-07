package com.example.cmsmobile.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.cmsmobile.entity.Account_Class;
import com.example.cmsmobile.entity.Classes;

import java.util.List;
import java.util.Optional;

@Dao
public interface Account_ClassDAO {

    @Query("SELECT * FROM Account_Class WHERE account_id = :account_id")
    List<Account_Class> findClassesByAccountId(int account_id);

    @Query("Select * from Account_Class")
    List<Account_Class> getAll();

    @Insert
    void addAccount_Class(Account_Class account_class);

}
