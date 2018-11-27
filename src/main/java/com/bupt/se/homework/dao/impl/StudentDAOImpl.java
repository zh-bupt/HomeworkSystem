package com.bupt.se.homework.dao.impl;

import com.bupt.se.homework.dao.StudentDAO;
import com.bupt.se.homework.entity.*;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository("studentDAO")
public class StudentDAOImpl extends BasicDAOImpl<Student, String> implements StudentDAO {

    /**
     * @Description: 查询学生作业对应的HomeGroup对象
     * @param student
     * @param homework
     * @return: com.bupt.se.homework.entity.HomeworkGroup
     * @Author: zh
     * @Date: 2018/11/27
     **/
    @Override
    public HomeworkGroup getHomeworkGroup(Student student, Homework homework) {
        String hql = "from HomeworkGroup as hg " +
                "where homeworkId = ? " +
                "and groupId in " +
                "(select group_.groupId from GroupStudent where studentId = ?)";
        Session session = getSession();
        Query query = session.createQuery(hql);
        query.setParameter(0, homework.getHomeworkId());
        query.setParameter(1, student.getStudentId());
        HomeworkGroup homeworkGroup = (HomeworkGroup) query.uniqueResult();
        return homeworkGroup;
    }

    /**
     * @Description: 取得学生相应课程的小组
     * @param student
     * @param course
     * @return: com.bupt.se.homework.entity.Group_
     * @Author: zh
     * @Date: 2018/11/27
     **/
    @Override
    public Group_ getCourseGroup(Student student, Course course) {
        String hql = "from Group_ where groupId = " +
                "(select g.groupId from Group_ g join g.groupStudentList gsl " +
                "where g.course.courseId = ? " +
                "and ? in gsl.student.studentId)";
        Session session = getSession();
        Query query = session.createQuery(hql);
        query.setParameter(0, student.getStudentId());
        query.setParameter(1, course.getCourseId());
        Group_ group_ = (Group_) query.uniqueResult();
        return group_;
    }
}
