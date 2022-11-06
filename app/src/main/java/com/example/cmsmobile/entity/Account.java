package com.example.cmsmobile.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Account {
    @PrimaryKey(autoGenerate = true)
    private int account_id;

    private String email;
    private String password;
    private String username;
    private String address;
    private String phone;
    private int role_id;// luc add account phai tu cung cap truong nay
    private int token_change_password;

    public Account() {
    }

    public int getToken_change_password() {
        return token_change_password;
    }

    public void setToken_change_password(int token_change_password) {
        this.token_change_password = token_change_password;
    }

    public Account(int account_id, String email, String password, String username, String address, String phone, int role_id, int token_change_password) {
        this.account_id = account_id;
        this.email = email;
        this.password = password;
        this.username = username;
        this.address = address;
        this.phone = phone;
        this.role_id = role_id;
        this.token_change_password = token_change_password;
    }

    public Account(String email, String password, String username, String address, String phone, int role_id) {
        this.email = email;
        this.password = password;
        this.username = username;
        this.address = address;
        this.phone = phone;
        this.role_id = role_id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }
}
