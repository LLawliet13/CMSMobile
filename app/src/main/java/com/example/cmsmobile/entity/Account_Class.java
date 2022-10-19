package com.example.cmsmobile.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Account_Class {

    private Integer account_id;
    private Integer class_id;

    public Account_Class() {
    }

    public Integer getAccount_id() {
        return account_id;
    }

    public void setAccount_id(Integer account_id) {
        this.account_id = account_id;
    }

    public Integer getClass_id() {
        return class_id;
    }

    public void setClass_id(Integer class_id) {
        this.class_id = class_id;
    }
}
