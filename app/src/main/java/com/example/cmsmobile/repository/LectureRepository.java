package com.example.cmsmobile.repository;

import android.content.Context;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.cmsmobile.dao.CourseDAO;
import com.example.cmsmobile.dao.LectureDAO;
import com.example.cmsmobile.entity.CMSDatabase;
import com.example.cmsmobile.entity.Course;
import com.example.cmsmobile.entity.Lecture;

import java.util.List;

public class LectureRepository {
    private LectureDAO lectureDAO;

    public LectureRepository(Context context) {
        lectureDAO = CMSDatabase.getInstance(context).lectureDAO();
    }

    public LectureDAO getLectureDAO() {
        return lectureDAO;
    }

    public void addLecture(Lecture lecture){
        lectureDAO.insertLecture(lecture);
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    public Lecture getLectureById(int id) throws Exception {
        return lectureDAO.findById(id).orElseThrow(()->
                new Exception("No Lecture Found")
        );
    }
    public List<Lecture> getAllLectures(){
        return lectureDAO.getAllLecture();
    }
    public void updateLecture(Lecture lecture){
        lectureDAO.updateLecture(lecture);
    }
    public List<Lecture> getLecturesByCourseId(int id){
        return lectureDAO.getLectureByCourseId(id);
    }

}
