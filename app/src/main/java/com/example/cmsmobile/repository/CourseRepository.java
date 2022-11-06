package com.example.cmsmobile.repository;

import android.content.Context;

import com.example.cmsmobile.dao.CourseDAO;
import com.example.cmsmobile.entity.Account;
import com.example.cmsmobile.entity.CMSDatabase;
import com.example.cmsmobile.entity.Course;

import java.util.List;

public class CourseRepository {
    private CourseDAO courseDAO;

    public CourseRepository(Context context) {
        courseDAO = CMSDatabase.getInstance(context).courseDAO();
    }

    public CourseDAO getCourseDAO() {
        return courseDAO;
    }

    public List<Course> getCourseByName(String name) {
        List<Course> courseList = courseDAO.getAllCourse();
        List<Course> courseList1 = courseDAO.getAllCourse();
        for (Course c : courseList) {
            if(c.getName().contains(name)){
                courseList1.add(c);
            }

        }
        return courseList1;
    }
}
