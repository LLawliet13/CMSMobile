package com.example.cmsmobile.repository;

import android.content.Context;

import com.example.cmsmobile.dao.ClassesDAO;
import com.example.cmsmobile.entity.CMSDatabase;
import com.example.cmsmobile.entity.Classes;
import com.example.cmsmobile.entity.Exam;

import java.util.List;

public class ClassRepository {
    private ClassesDAO classesDAO;

    public ClassRepository(Context context) {
        classesDAO = CMSDatabase.getInstance(context).classesDAO();
    }

    public ClassesDAO getClassesDAO() {
        return classesDAO;
    }

    public void addClasses(Classes classes) {
        classesDAO.insert(classes);
    }

    public Classes getClassById(int id){
        return classesDAO.findById(id);
    }

    public List<Classes> getAllClasses() {
        return classesDAO.getAll();
    }

    public void updateClasses(Classes classes) {
        classesDAO.updateClass(classes);
    }

    public void removeClasses(Classes classes) {
        classesDAO.delete(classes);
    }

}
