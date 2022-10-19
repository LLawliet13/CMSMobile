package com.example.cmsmobile.entity;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.cmsmobile.dao.AccountDAO;
import com.example.cmsmobile.dao.RoleDAO;

@Database(entities = {Role.class,Account.class},version = 1)
public abstract class CMSDatabase extends RoomDatabase {
    public abstract RoleDAO roleDAO();
    public abstract AccountDAO accountDAO();
    private static volatile CMSDatabase INSTANCE;

    public static CMSDatabase getInstance(Context context){
        if(INSTANCE == null){
            synchronized (CMSDatabase.class){
                if(INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            CMSDatabase.class,"CMSMobileDB").allowMainThreadQueries().build();
                }
            }
        }
        return INSTANCE;
    }
}
