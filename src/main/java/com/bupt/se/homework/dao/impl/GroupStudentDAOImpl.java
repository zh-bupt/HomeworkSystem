package com.bupt.se.homework.dao.impl;

import com.bupt.se.homework.dao.GroupStudentDAO;
import com.bupt.se.homework.entity.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("groupStudentDAO")
public class GroupStudentDAOImpl
        extends BasicDAOImpl<GroupStudent, GroupStudentPK> implements GroupStudentDAO {
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

    public List<Student> findLeftStudentList(String courseID) {
        // 获取实体名
        //String entityName = entityClass.getSimpleName();
        Session session = getSession();
        //Transaction transaction = session.beginTransaction();
        List<Student> firstList = new ArrayList<>();
        List<Student> secondList = new ArrayList<>();
        List<Student> lastList = new ArrayList<>();
        String EntiName = "StudentCourse";
        String hql = "select sc from " + EntiName + " as sc";
        //TODO BY LEE java.lang.NullPointerException at org.hibernate.hql.internal.NameGenerator.generateColumnNames(NameGenerator.java:27)
        List<StudentCourse> allStuCou = session.createQuery(hql).list();
        EntiName = "GroupStudent";
        hql = "select gs from " + EntiName + " as gs";
        List<GroupStudent> allGroStu = session.createQuery(hql).list();
        //transaction.commit();
		int isChosen = 0;
        for(StudentCourse StuCou: allStuCou) {
            Course course = StuCou.getCourse();
            if (course.getCourseId().equals(courseID)) {
                firstList.add(StuCou.getStudent());
            }
        }
        for(GroupStudent GroStu : allGroStu){
            Group_ group = GroStu.getGroup_();
            Course course = group.getCourse();
            if(course.getCourseId().equals(courseID)){
                secondList.add(GroStu.getStudent());
            }
        }
        for(Student student : firstList)
            System.out.println(student.getStudentId());
        for(Student student : secondList)
            System.out.println(student.getStudentId());

        for(Student student : firstList){

			isChosen = 0;
            for(Student student2 : secondList){
                if(student.getStudentId().equals(student2.getStudentId()))
						isChosen = 1;
            }
			if(isChosen == 0)
				lastList.add(student);

        }

        return lastList;
    }

    @Override
    public void setContribution(Group_ g, Student s, int contribution) {
        String hql = "update GroupStudent gs set gs.contribution = ? " +
                "where gs.group_.groupId = ? " +
                "and gs.student.studentId = ?";
        Session session = getSession();
        Transaction tx = session.beginTransaction();
        try {
            Query query = session.createQuery(hql);
            query.setParameter(0, contribution);
            query.setParameter(1, g.getGroupId());
            query.setParameter(2, s.getStudentId());
            query.executeUpdate();
            tx.commit();
        } catch (Exception e) {
            logger.error(e);
            tx.rollback();
        }
    }
}
