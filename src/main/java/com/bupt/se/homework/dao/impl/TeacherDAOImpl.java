package com.bupt.se.homework.dao.impl;

import com.bupt.se.homework.bo.ReturnCode;
import com.bupt.se.homework.dao.TeacherDAO;
import com.bupt.se.homework.entity.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import java.util.Set;

@Repository("teacherDAO")
public class TeacherDAOImpl extends BasicDAOImpl<Teacher, String> implements TeacherDAO {

    @Override
    public int AssignHomework(Course course, Homework homework) {
        course.getHomework().add(homework);
        if (CalculateHomePercentage(course) > 100) {
            return ReturnCode.HOMEWORK_PERCENTAGE_EXCEEDED;
        }
        Session session = getSession();
        // 保存作业
        homework.setCourse(course);
        session.save(homework);
        // 更新课程的作业列表
        session.update(course);
        // 更新group的作业列表
        Set<Group_> groupSet = course.getGroups();
        for (Group_ g:groupSet) {
            HomeworkGroup hg = new HomeworkGroup(homework, g);
            g.getHomeworkGroups().add(hg);
            session.update(g);
            homework.getHomeworkGroups().add(hg);
            session.save(hg);
        }
        session.update(homework);
        return ReturnCode.ASSIGN_HOMEWORK_SUCCESS;
    }

    private int CalculateHomePercentage(Course course) {
        Set<Homework> homeworkSet = course.getHomework();
        int total = 0;
        for (Homework homework:homeworkSet) {
            total += homework.getPercentage();
            System.out.println("total: " + total);
        }
        return total;
    }
}
