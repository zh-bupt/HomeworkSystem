package com.bupt.se.homework.dao.impl;

import com.bupt.se.homework.dao.TeacherDAO;
import com.bupt.se.homework.entity.Admin;
import com.bupt.se.homework.entity.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;


import java.util.List;


public class TeacherDAOImpl implements TeacherDAO {

    private SessionFactory sessionFactory;

    @Autowired
    @Qualifier("sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addTeacher(Teacher teacher) {

        Session s = sessionFactory.getCurrentSession();
        Transaction tx = s.beginTransaction();
        s.save(teacher);
        tx.commit();

    }

    //return all the customers in list
    @Override
    public List<Teacher> listTeacher() {
//        HibernateTemplate ht = getHibernateTemplate();
//        if(ht==null)
//        {
//            System.out.println("listTeacher() getHibernateTemplate() is null");
//            return null;
//        }
//        else
//        {
//            System.out.println("listTeacher() getHibernateTemplate() is not null");
//            return  (List<Teacher>)getHibernateTemplate().find("from Teacher");
//        }
        Session s = sessionFactory.getCurrentSession();
        Transaction tx= s.beginTransaction();
        String hql = "from Teacher";
        Query query = s.createQuery(hql);
        List<Teacher> teacherList =  query.list();
        tx.commit();
        return teacherList;
    }

    /**
     * @Description: 根据ID查询Teacher
     * @param id
     * @return: com.bupt.se.homework.entity.Teacher
     * @Author: zh
     * @Date: 2018/11/10
     **/
    @Override
    public Teacher queryById(String id) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = null;
        Teacher teacher = null;
        try{
            transaction = session.beginTransaction();
            teacher = session.get(Teacher.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (transaction != null) {
                transaction.commit();
            }
        }
        return teacher;
    }

}
