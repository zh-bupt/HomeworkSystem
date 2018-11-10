package com.bupt.se.homework.dao.impl;

import com.bupt.se.homework.dao.AdminDAO;
import com.bupt.se.homework.entity.Admin;

public class AdminDAOImpl extends BasicDAOImpl<Admin, String> implements AdminDAO {

//    SessionFactory sessionFactory;
//
//    @Autowired
//    @Qualifier("sessionFactory")
//    public void setSessionFactory(SessionFactory sessionFactory) {
//        this.sessionFactory = sessionFactory;
//    }


//    /**
//     * @Description: 根据ID查询Admin用户
//     * @param id
//     * @return: com.bupt.se.homework.entity.Admin
//     * @Author: zh
//     * @Date: 2018/11/10
//     **/
//    @Override
//    public Admin queryById(String id) {
//        Session session = sessionFactory.getCurrentSession();
//        Transaction transaction = null;
//        Admin admin = null;
//        try{
//            transaction = session.beginTransaction();
//            admin = session.get(Admin.class, id);
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            if (transaction != null) {
//                transaction.commit();
//            }
//        }
//        return admin;
//    }
//
//    @Override
//    public boolean add(Admin admin) {
//        return false;
//    }

//    @Override
//    public boolean update(Admin admin) {
//        return false;
//    }

//    @Override
//    public boolean delete(String id) {
//        return false;
//    }
}
