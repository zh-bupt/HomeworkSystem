package com.bupt.se.homework.dao.impl;

import com.bupt.se.homework.dao.TeacherDAO;
//import com.bupt.se.homework.entity.Student;
import com.bupt.se.homework.entity.Teacher;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
//import org.hibernate.query.Query;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//
//import java.util.List;


public class TeacherDAOImpl extends BasicDAOImpl<Teacher, String> implements TeacherDAO {

//    private SessionFactory sessionFactory;
//
//    @Autowired
//    @Qualifier("sessionFactory")
//    public void setSessionFactory(SessionFactory sessionFactory) {
//        this.sessionFactory = sessionFactory;
//    }
//
//    /**
//     * @Description: add a new Teacher
//     * @param teacher
//     * @return: boolean
//     * @Author: zh
//     * @Date: 2018/11/10
//     **/
//    @Override
//    public boolean add(Teacher teacher) {
//        Session s = sessionFactory.getCurrentSession();
//        Transaction transaction = null;
//        try {
//            transaction = s.beginTransaction();
//            s.save(teacher);
//            transaction.commit();
//            return true;
//        } catch (Exception e) {
//            e.printStackTrace();
//            transaction.commit();
//            return false;
//        }
//    }
//
//    @Override
//    public boolean update(Teacher teacher) {
//        Session s = sessionFactory.getCurrentSession();
//        Transaction transaction = null;
//        try {
//            transaction = s.beginTransaction();
//            s.update(teacher);
//            transaction.commit();
//            return true;
//        } catch (Exception e) {
//            e.printStackTrace();
//            transaction.commit();
//            return false;
//        }
//    }
//
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
//     * @Description: 得到所有教师的List
//     * @param
//     * @return: java.util.List<com.bupt.se.homework.entity.Teacher>
//     * @Author: zh
//     * @Date: 2018/11/10
//     **/
//    @Override
//    public List<Teacher> listTeacher() {
//
//        Session s = sessionFactory.getCurrentSession();
//        Transaction transaction = null;
//        List<Teacher> list = null;
//        try {
//            transaction = s.beginTransaction();
//            String hql = "from Teacher";
//            Query query = s.createQuery(hql);
//            list =  query.list();
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            if (transaction != null) {
//                transaction.commit();
//            }
//        }
//        return list;
//    }
//
//    /**
//     * @Description: 根据ID查询Teacher
//     * @param id
//     * @return: com.bupt.se.homework.entity.Teacher
//     * @Author: zh
//     * @Date: 2018/11/10
//     **/
//    @Override
//    public Teacher queryById(String id) {
//        Session session = sessionFactory.getCurrentSession();
//        Transaction transaction = null;
//        Teacher teacher = null;
//        try{
//            transaction = session.beginTransaction();
//            teacher = session.get(Teacher.class, id);
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            if (transaction != null) {
//                transaction.commit();
//            }
//        }
//        return teacher;
//    }
}
