package com.example.cmsmobile.repository;

import android.content.Context;

import com.example.cmsmobile.dao.AccountDAO;
import com.example.cmsmobile.dao.AnnouncementDAO;
import com.example.cmsmobile.entity.Account;
import com.example.cmsmobile.entity.Announcement;
import com.example.cmsmobile.entity.CMSDatabase;

public class AnnouncementRepository {
    private AnnouncementDAO announcementDAO;

    public AnnouncementRepository(Context context) {
        announcementDAO = CMSDatabase.getInstance(context).announcementDAO();
    }

    public AnnouncementDAO getAnnouncementDAO() {
        return announcementDAO;
    }
    public void addAnnouncement(Announcement announcement){
        announcementDAO.insert(announcement);
    }
}
