package com.bupt.se.homework.action;

import com.bupt.se.homework.bo.AdminBo;
import com.bupt.se.homework.bo.impl.AdminBoImpl;
import com.bupt.se.homework.dao.impl.AdminDAOImpl;

public class AdminAction {
    private AdminBo adminBo;

    public void setAdminBo(AdminBo adminBo) {
        this.adminBo = adminBo;
    }
}
