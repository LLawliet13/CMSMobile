package com.example.cmsmobile.dao;



import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.cmsmobile.entity.Account;


@Database(entities = {Account.class}, version = 1)
public abstract class AccountRoomDatabase extends RoomDatabase {
    private final static String DATABASE_NAME = "CMSMobileApp";

    public abstract AccountDAO accountDAO();

    private static AccountRoomDatabase INSTANCE;

    public static AccountRoomDatabase getDataBase(Context context) {
        synchronized (AccountRoomDatabase.class) {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context, AccountRoomDatabase.class, "CMSMobileApp").allowMainThreadQueries().fallbackToDestructiveMigration().build();
            }
        }
        return INSTANCE;
    }
}


