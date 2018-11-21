package com.bupt.se.homework.bo.impl;

import com.bupt.se.homework.bo.AdminBo;
import com.bupt.se.homework.bo.ReturnCode;
import com.bupt.se.homework.dao.AdminDAO;
import com.bupt.se.homework.dao.BasicDao;
import com.bupt.se.homework.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("adminBo")
@Transactional
public class AdminBoImpl extends BasicBoImpl<Admin, String> implements AdminBo {


    private AdminDAO adminDAO;

    public AdminBoImpl() {
    }

    @Autowired
    public void setAdminDAO(BasicDao<Admin, String> basicDao) {
        super.setBasicDao(basicDao);
        this.adminDAO = (AdminDAO) basicDao;
    }

    /**
     * @Description: 管理员登录
     * @param id
     * @param password
     * @return: java.lang.String
     * @Author: zh
     * @Date: 2018/11/10
     **/
    @Override
    public String login(String id, String password) {
        Admin admin = adminDAO.get(id);
        if (admin == null) return ReturnCode.USER_NOT_FOUNT;
        if (!admin.getPassword().equals(password)) return ReturnCode.WRONG_PASSWORD;
        return ReturnCode.LOGIN_SUCCESS;
    }

    @Override
    public void updateAdmin(Admin admin) {

    }

    @Override
    public void addAdmin(Admin admin) {

    }

    @Override
    public void deleteAdmin(String id) {

    }
}
