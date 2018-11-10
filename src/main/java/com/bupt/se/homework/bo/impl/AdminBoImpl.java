package com.bupt.se.homework.bo.impl;

import com.bupt.se.homework.bo.AdminBo;
import com.bupt.se.homework.bo.ReturnCode;
import com.bupt.se.homework.dao.AdminDAO;
import com.bupt.se.homework.entity.Admin;

import java.util.Map;

public class AdminBoImpl implements AdminBo {


    private AdminDAO adminDAO;

    public AdminDAO getAdminDAO() {
        return adminDAO;
    }

    @Override
    public String login(String id, String password) {
        Admin admin = adminDAO.queryById(id);
        if (admin == null) return ReturnCode.USER_NOT_FOUNT;
        if (admin.getPassword() == null || !admin.getPassword().equals(password)) return ReturnCode.WRONG_PASSWORD;
        return ReturnCode.LOGIN_SUCCESS;
    }

    public void setAdminDAO(AdminDAO adminDAO) {
        this.adminDAO = adminDAO;
    }
}
