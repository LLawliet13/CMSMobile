package com.example.cmsmobile.repository;

import android.content.Context;

import com.example.cmsmobile.dao.AccountDAO;
import com.example.cmsmobile.dao.AnnouncementDAO;
import com.example.cmsmobile.entity.Account;
import com.example.cmsmobile.entity.Announcement;
import com.example.cmsmobile.entity.CMSDatabase;
import com.example.cmsmobile.entity.Course;

import java.util.ArrayList;
import java.util.List;

public class AnnouncementRepository {
    private AnnouncementDAO announcementDAO;

    public AnnouncementRepository(Context context) {
        announcementDAO = CMSDatabase.getInstance(context).announcementDAO();
    }

    public List<Announcement> getAnnouncementDAO() {
        return announcementDAO.getAllAnnouncement();
    }
    public void addAnnouncement(Announcement announcement){
        announcementDAO.insert(announcement);
    }
    public List<Announcement> getAllAnnouncement(){

        List<Announcement> announcementList = new ArrayList<>();
        announcementList.addAll(announcementDAO.getAllAnnouncement());
        return announcementList;
    }
}
