package com.bupt.se.homework.dao.impl;

import com.bupt.se.homework.dao.AdminDAO;
import com.bupt.se.homework.entity.Admin;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("adminDAO")
@Transactional
public class AdminDAOImpl extends BasicDAOImpl<Admin, String> implements AdminDAO {

}
