package com.bupt.se.homework.bo.impl;

import com.bupt.se.homework.bo.CourseBo;
import com.bupt.se.homework.bo.GroupBo;
import com.bupt.se.homework.dao.BasicDao;
import com.bupt.se.homework.dao.CourseDAO;
import com.bupt.se.homework.dao.GroupDAO;
import com.bupt.se.homework.dao.StudentCourseDAO;
import com.bupt.se.homework.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @description: CourseBo 实现类
 * @author: zh
 * @create: 2018-11-15 16:38
 **/
@Service("courseBo")
public class CourseBoImpl extends BasicBoImpl<Course, String> implements CourseBo {

    private CourseDAO courseDAO;
    private GroupBo groupBo;
    private StudentCourseDAO studentCourseDAO;

    @Autowired
    @Qualifier("courseDAO")
    public void setCourseDAO(BasicDao<Course, String> basicDao) {
        super.setBasicDao(basicDao);
        this.courseDAO = (CourseDAO) basicDao;
    }

    @Autowired
    public void setGroupBo(GroupBo groupBo) {
        this.groupBo = groupBo;
    }

    @Autowired
    public void setStudentCourseDAO(StudentCourseDAO studentCourseDAO) {
        this.studentCourseDAO = studentCourseDAO;
    }

    @Override
    public Set<StudentCourse> getStudentCourse(Course course) {
        return course.getStudentCourses();
    }

    @Override
    public List<Student> getStudents(Course course) {
        Set<StudentCourse> studentCourses = course.getStudentCourses();
        List<Student> list = null;
        if (studentCourses != null && studentCourses.size() > 0) {
            list = new ArrayList<>();
            for (StudentCourse sc:studentCourses) {
                list.add(sc.getStudent());
            }
        }
        return list;
    }

    /**
     * @Description: 课程成绩统计
     * @param course
     * @return: java.util.Map<java.lang.String,java.lang.Object>
     * @Author: zh
     * @Date: 2018/11/15
     **/
    @Override
    public Map<String, Object> getStatistics(Course course) {
        Map<String, Object> map = new HashMap<>();
        int countPerTenScore[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int totalCount = 0;
        Set<StudentCourse> studentCourses = course.getStudentCourses();
        if (studentCourses != null && studentCourses.size() > 0) {
            for (StudentCourse sc:studentCourses) {
                countPerTenScore[(int) Math.floor(sc.getGrade() / 10)]++;
                totalCount++;
            }
        }
        map.put("count per 10 score", countPerTenScore);
        map.put("totalCount", totalCount);
        return map;
    }

    @Override
    public boolean addCourse(Course course) {
        return this.save(course);
    }

    @Override
    public List<Course> listCourse() {
        return this.getList(null, null, null, null, null, null, 0, 0);
    }

    @Override
    public List<Homework> listHomework(String courseId) {
        Course course = courseDAO.get(courseId);
        List<Homework> list = null;
        if (course != null) {
            Set<Homework> homeworkSet = course.getHomework();
            if (homeworkSet != null && homeworkSet.size() > 0) {
                list = new ArrayList<>();
                for (Homework h:homeworkSet) {
                    list.add(h);
                }
            }
        }
        return list;
    }

    @Override
    public void calculateScore(Course course) {
        Set<Group_> groups = course.getGroups();
        if (groups != null && groups.size() > 0) {
            for (Group_ g:groups) {
                // 先计算小组成绩
                groupBo.calculateScore(g);
                // 再计算课程成绩
                Set<GroupStudent> groupStudents = g.getGroupStudentSet();
                if (groupStudents != null && groupStudents.size() > 0) {
                    for (GroupStudent gs:groupStudents) {
                        double courseScore = (gs.getContribution() / 100.) * gs.getGroup_().getGroupScore();
                        StudentCourse sc = new StudentCourse(gs.getStudent(), course);
                        sc.setGrade(courseScore);
                        studentCourseDAO.update(sc);
                    }

                }
            }

        }
    }
}
