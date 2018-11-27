package com.bupt.se.homework.bo.impl;

import com.bupt.se.homework.bo.AdminBo;
import com.bupt.se.homework.bo.ReturnCode;
import com.bupt.se.homework.dao.AdminDAO;
import com.bupt.se.homework.dao.BasicDao;
import com.bupt.se.homework.entity.Admin;
import com.bupt.se.homework.exception.ServiceException;
import com.bupt.se.homework.exception.ServiceExceptionErrorCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("adminBo")
public class AdminBoImpl extends BasicBoImpl<Admin, String> implements AdminBo {


    private AdminDAO adminDAO;

    public AdminBoImpl() {
    }

    @Autowired
    @Qualifier("adminDAO")
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
    public void updateAdmin(Admin admin) throws Exception {
        if (!exists(admin.getAdminId())) {
            throw new ServiceException(ServiceExceptionErrorCode.ADMIN_NOT_FOUND,
                    "管理员 " + admin.getAdminId() + " 不存在.");
        }
        this.update(admin);
    }

    @Override
    public void addAdmin(Admin admin) throws Exception {
        if (exists(admin.getAdminId())) {
            throw new ServiceException(ServiceExceptionErrorCode.ADMIN_DUPLICATED,
                    "管理员 " + admin.getAdminId() + " 已存在.");
        }
        this.save(admin);
    }

    @Override
    public void deleteAdmin(String id) throws Exception {
        this.delete(id);
    }
}
