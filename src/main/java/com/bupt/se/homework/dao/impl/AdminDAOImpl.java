package com.bupt.se.homework.dao.impl;

import com.bupt.se.homework.dao.AdminDAO;
import com.bupt.se.homework.entity.Admin;
import org.springframework.stereotype.Repository;

@Repository("adminDAO")
public class AdminDAOImpl extends BasicDAOImpl<Admin, String> implements AdminDAO {

}
