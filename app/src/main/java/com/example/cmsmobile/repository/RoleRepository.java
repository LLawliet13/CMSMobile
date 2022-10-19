package com.example.cmsmobile.repository;

import android.content.Context;

import com.example.cmsmobile.dao.RoleDAO;
import com.example.cmsmobile.entity.CMSDatabase;
import com.example.cmsmobile.entity.Role;

import java.util.List;

public class RoleRepository {
    private RoleDAO roleDAO;

    public RoleRepository(Context context) {
        roleDAO = CMSDatabase.getInstance(context).roleDAO();
    }

    public RoleDAO getRoleDAO() {
        return roleDAO;
    }

    public void setUpRoles() {
        roleDAO.insert(new Role(1, "ADMIN")
                , new Role(2, "TEACHER")
                , new Role(3, "STUDENT"));
    }
    public List<Role> getAllRoles(){
        return roleDAO.getAll();
    }
}
