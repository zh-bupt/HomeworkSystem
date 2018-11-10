package com.bupt.se.homework.dao.impl;

import com.bupt.se.homework.dao.StudentDAO;
import com.bupt.se.homework.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class StudentDAOImpl implements StudentDAO {
    @Qualifier("sessionFactory")
    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addStudent(Student student) {
        Session s = sessionFactory.openSession();
        Transaction tx = s.beginTransaction();
        s.save(student);
        tx.commit();
    }
}
