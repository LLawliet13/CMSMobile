package com.example.cmsmobile.repository;

import android.content.Context;

import com.example.cmsmobile.dao.ClassesDAO;
import com.example.cmsmobile.entity.CMSDatabase;
import com.example.cmsmobile.entity.Classes;

import java.util.List;

public class ClassRepository {
    private ClassesDAO classesDAO;

    public ClassRepository(Context context){
        classesDAO = CMSDatabase.getInstance(context).classesDAO();
    }

    public ClassesDAO getClassesDAO() {return classesDAO;}
    public List<Classes> getAllClassesList(){
        return classesDAO.getAll();
    }
    public void addClasses(Classes classes){classesDAO.insert(classes);}
}
