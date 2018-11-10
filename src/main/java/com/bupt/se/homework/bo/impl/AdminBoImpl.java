package com.bupt.se.homework.bo.impl;

import com.bupt.se.homework.dao.AdminDAO;
import com.bupt.se.homework.entity.Admin;

import java.util.Map;

public class AdminBoImpl {

    public static int ADMIN_NOT_FOUNT = 0x1111;
    public static int WRONG_PASSWORD = 0x1112;
    public static int LOGIN_SUCCESS = 0x1113;

    private AdminDAO adminDAO;

    public AdminDAO getAdminDAO() {
        return adminDAO;
    }

    public int login(String id, String password) {
        Admin admin = adminDAO.queryById(id);
        if (admin == null) return ADMIN_NOT_FOUNT;
        if (admin.getPassword() == null || !admin.getPassword().equals(password)) return WRONG_PASSWORD;
        return LOGIN_SUCCESS;
    }

    public void setAdminDAO(AdminDAO adminDAO) {
        this.adminDAO = adminDAO;
    }
}
