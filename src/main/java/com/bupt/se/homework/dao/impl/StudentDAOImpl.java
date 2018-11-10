package com.bupt.se.homework.dao.impl;

import com.bupt.se.homework.dao.StudentDAO;
import com.bupt.se.homework.entity.Admin;
import com.bupt.se.homework.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class StudentDAOImpl implements StudentDAO {

    private SessionFactory sessionFactory;

    @Autowired
    @Qualifier("sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addStudent(Student student) {
        Session s = sessionFactory.getCurrentSession();
        Transaction tx = s.beginTransaction();
        s.save(student);
        tx.commit();
    }

    /**
     * @Description: 根据ID查询学生
     * @param id
     * @return: com.bupt.se.homework.entity.Student
     * @Author: zh
     * @Date: 2018/11/10
     **/
    @Override
    public Student queryById(String id) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = null;
        Student student = null;
        try{
            transaction = session.beginTransaction();
            student = session.get(Student.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (transaction != null) {
                transaction.commit();
            }
        }
        return student;
    }
}
