package com.bupt.se.homework.bo.impl;

import com.bupt.se.homework.bo.AdminBo;
import com.bupt.se.homework.dao.AdminDAO;

public class AdminBoImpl implements AdminBo {
    private AdminDAO adminDAO;

    public AdminDAO getAdminDAO() {
        return adminDAO;
    }

    public void setAdminDAO(AdminDAO adminDAO) {
        this.adminDAO = adminDAO;
    }

    @Override
    public String login(String account, String password) {
        return null;
    }
}
