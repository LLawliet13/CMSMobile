package com.example.cmsmobile.entity;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.cmsmobile.dao.AccountDAO;

import com.example.cmsmobile.dao.Account_ClassDAO;

import com.example.cmsmobile.dao.AnnouncementDAO;

import com.example.cmsmobile.dao.ClassesDAO;
import com.example.cmsmobile.dao.CourseDAO;
<<<<<<< HEAD
import com.example.cmsmobile.dao.LectureDAO;
=======
import com.example.cmsmobile.dao.ExamDAO;
>>>>>>> 4cf7b48fa9e653fe706eff53360cc1a4036d1ab8
import com.example.cmsmobile.dao.FeedbackDAO;
import com.example.cmsmobile.dao.RoleDAO;
import com.example.cmsmobile.dao.SubmissionDAO;


<<<<<<< HEAD
@Database(entities = {Role.class, Account.class, Submission.class, Classes.class,Course.class,Announcement.class,Account_Class.class, Lecture.class}, version = 1)

=======
@Database(entities = {Role.class, Account.class, Submission.class, Classes.class,Course.class,Announcement.class,Account_Class.class
, Exam.class}, version = 1)
>>>>>>> 4cf7b48fa9e653fe706eff53360cc1a4036d1ab8
public abstract class CMSDatabase extends RoomDatabase {
    public abstract RoleDAO roleDAO();

    public abstract AccountDAO accountDAO();

    public abstract ClassesDAO classesDAO();
    public abstract LectureDAO lectureDAO();
    public abstract SubmissionDAO submissionDAO();

    public abstract ExamDAO examDAO();

    public abstract Account_ClassDAO account_classDAO();

    public abstract CourseDAO courseDAO();
    public abstract AnnouncementDAO announcementDAO();
    public abstract FeedbackDAO feedbackDAO();

    private static volatile CMSDatabase INSTANCE;

    public static CMSDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (CMSDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            CMSDatabase.class, "CMSMobileDB").allowMainThreadQueries().build();
                }
            }
        }
        return INSTANCE;
    }
}
