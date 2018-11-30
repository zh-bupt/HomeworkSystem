package com.bupt.se.homework.dao.impl;

import com.bupt.se.homework.bo.ReturnCode;
import com.bupt.se.homework.dao.TeacherDAO;
import com.bupt.se.homework.entity.*;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("teacherDAO")
public class TeacherDAOImpl extends BasicDAOImpl<Teacher, String> implements TeacherDAO {

    @Override
    public void assignHomework(Course course, Homework homework) throws Exception {
        Session session = getSession();
        // 保存作业
        homework.setCourse(course);
        session.save(homework);
        // 更新课程的作业列表
        session.update(course);
        // 更新group的作业列表
        List<Group_> groupSet = course.getGroups();
        for (Group_ g:groupSet) {
            HomeworkGroup hg = new HomeworkGroup(homework, g);
            g.getHomeworkGroups().add(hg);
            session.update(g);
            homework.getHomeworkGroups().add(hg);
            session.save(hg);
        }
        session.update(homework);
    }
}
