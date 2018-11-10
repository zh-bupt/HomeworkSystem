package com.bupt.se.homework.dao.impl;

import com.bupt.se.homework.dao.StudentDAO;
import com.bupt.se.homework.entity.Student;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
//import org.hibernate.query.Query;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//
//import java.util.List;

public class StudentDAOImpl extends BasicDAOImpl<Student, String> implements StudentDAO {

//    private SessionFactory sessionFactory;
//
//    @Autowired
//    @Qualifier("sessionFactory")
//    public void setSessionFactory(SessionFactory sessionFactory) {
//        this.sessionFactory = sessionFactory;
//    }

//    @Override
//    public boolean add(Student student) {
//        Session s = sessionFactory.getCurrentSession();
//        Transaction transaction = null;
//        try {
//            transaction = s.beginTransaction();
//            s.save(student);
//            transaction.commit();
//            return true;
//        } catch (Exception e) {
//            e.printStackTrace();
//            transaction.commit();
//            return false;
//        }
//    }

//    @Override
//    public boolean update(Student student) {
//        Session s = sessionFactory.getCurrentSession();
//        Transaction transaction = null;
//        try {
//            transaction = s.beginTransaction();
//            s.update(student);
//            transaction.commit();
//            return true;
//        } catch (Exception e) {
//            e.printStackTrace();
//            transaction.commit();
//            return false;
//        }
//    }

//    @Override
//    public boolean delete(String id) {
//        Session s = sessionFactory.getCurrentSession();
//        Transaction transaction = null;
//        try {
//            transaction = s.beginTransaction();
//            Student student = s.get(Student.class, id);
//            s.delete(student);
//            transaction.commit();
//            return true;
//        } catch (Exception e) {
//            e.printStackTrace();
//            transaction.commit();
//            return false;
//        }
//    }
//
//    /**
//     * @Description: 根据ID查询学生
//     * @param id
//     * @return: com.bupt.se.homework.entity.Student
//     * @Author: zh
//     * @Date: 2018/11/10
//     **/
//    @Override
//    public Student queryById(String id) {
//        Session session = sessionFactory.getCurrentSession();
//        Transaction transaction = null;
//        Student student = null;
//        try{
//            transaction = session.beginTransaction();
//            student = session.get(Student.class, id);
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            if (transaction != null) {
//                transaction.commit();
//            }
//        }
//        return student;
//    }

//    /**
//     * @Description: 获取一个班级的学生列表
//     * @param classId
//     * @return: java.util.List<com.bupt.se.homework.entity.Student>
//     * @Author: zh
//     * @Date: 2018/11/10
//     **/
//    @Override
//    public List<Student> queryByClass(String classId) {
//        Session session = sessionFactory.getCurrentSession();
//        Transaction transaction = null;
//        List<Student> list = null;
//        try{
//            transaction = session.beginTransaction();
//            String hql = "from student where CLASS_ID=?";
//            Query query = session.createQuery(hql);
//            query.setParameter(0, classId);
//            list = query.list();
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            if (transaction != null) {
//                transaction.commit();
//            }
//        }
//        return list;
//    }

//    @Override
//    public List<Student> queryByName(String name) {
//        Session session = sessionFactory.getCurrentSession();
//        Transaction transaction = null;
//        List<Student> list = null;
//        try{
//            transaction = session.beginTransaction();
//            String hql = "from student where STUDENT_NAME = ?";
//            Query query = session.createQuery(hql);
//            query.setParameter(0, name);
//            list = query.list();
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            if (transaction != null) {
//                transaction.commit();
//            }
//        }
//        return list;
//    }
}
