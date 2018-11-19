package com.bupt.se.homework.dao.impl;

import com.bupt.se.homework.dao.GroupStudentDAO;
import com.bupt.se.homework.dao.HibernateDaoUtil;
import com.bupt.se.homework.dao.StudentDAO;
import com.bupt.se.homework.entity.Group;
import com.bupt.se.homework.entity.Student;
import com.bupt.se.homework.entity.StudentCourse;
import com.bupt.se.homework.entity.Course;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.LinkedHashMap;
import java.util.List;

public class GroupStudentDAOImpl implements GroupStudentDAO {
    private SessionFactory sessionFactory;

    protected Logger logger = LogManager.getLogger(getClass());

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Session getSession() {
        return sessionFactory.openSession();
    }



    public GroupStudentDAOImpl() {

    }

    public List<Student> findResultList(String courseID) {
        // 获取实体名
        //String entityName = entityClass.getSimpleName();
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        List<Student> firstList = null;
        List<Student> secondList = null;
        List<Student> lastList = null;
        List<List> allStuCou = session.createQuery("select new list(Student,Course) from StudentCourse").list();
        List<List> allGroStu = session.createQuery("select new list(Group,Student) from GroupStudent").list();
        transaction.commit();
        for(List StuCou : allStuCou){
            Course course = (Course)StuCou.get(1);
            if(course.getCourseId() == courseID){
                firstList.add((Student)StuCou.get(0));
            }
        }
        for(List GroStu : allGroStu){
            Group group = (Group)GroStu.get(0);
            Course course = group.getCourse();
            if(course.getCourseId() == courseID){
                secondList.add((Student)GroStu.get(1));
            }
        }
        for(Student student : firstList){
            for(Student student2 : secondList){
                if(student.getStudentId() != student2.getStudentId())
                    lastList.add(student);
            }
        }

        return lastList;
    }
}
