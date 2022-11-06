package com.example.cmsmobile.repository;

import android.content.Context;

import com.example.cmsmobile.dao.AccountDAO;
import com.example.cmsmobile.dao.Account_ClassDAO;
import com.example.cmsmobile.entity.Account_Class;
import com.example.cmsmobile.entity.CMSDatabase;

import java.util.List;

public class Account_ClassRepository {
    private Account_ClassDAO account_classDAO;

    public Account_ClassRepository(Context context) {
        account_classDAO = CMSDatabase.getInstance(context).account_classDAO();
    }
    public List<Account_Class> getAllAccount_Class(){
        return account_classDAO.getAll();
    }
    public List<Account_Class> findClassesOfATeacher(int teacher_id){
        return account_classDAO.findClassesByAccountId(teacher_id);
    }
}
