package com.example.cmsmobile.repository;

import android.content.Context;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.cmsmobile.dao.AccountDAO;

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

    public void addCourse(Course course){
        courseDAO.insertCourse(course);
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    public Course getCourseById(int id) throws Exception {
        return courseDAO.findById(id).orElseThrow(()->
                new Exception("No Course Found")
        );
    }
    public List<Course> getAllCourses(){
        return courseDAO.getAllCourse();
    }
    public void updateCourse(Course course){
        courseDAO.updateCourse(course);
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

    public Course course(int id){
        return courseDAO.findCourseById(id);
    }

    public Course getCourseByClassId(int class_id){
        return courseDAO.findCourseByClassId(class_id);
    }
}
