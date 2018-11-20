package com.bupt.se.homework.dao.impl;

import com.bupt.se.homework.dao.StudentDAO;
import com.bupt.se.homework.entity.Homework;
import com.bupt.se.homework.entity.HomeworkGroup;
import com.bupt.se.homework.entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class StudentDAOImpl extends BasicDAOImpl<Student, String> implements StudentDAO {

    @Override
    public HomeworkGroup getHomeworkGroup(Student student, Homework homework) {
        String hql = "from HomeworkGroup as hg " +
                "where homeworkId = ? " +
                "and groupId in " +
                "(select group_.groupId from GroupStudent where studentId = ?)";
//        String hql = "from HomeworkGroup where groupId = ?";
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        HomeworkGroup homeworkGroup = null;
        try {
            Query query = session.createQuery(hql);
            query.setParameter(0, homework.getHomeworkId());
            query.setParameter(1, student.getStudentId());
            homeworkGroup = (HomeworkGroup) query.uniqueResult();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
        return homeworkGroup;
    }
}
