package com.bupt.se.homework.bo.impl;

import com.bupt.se.homework.bo.CourseBo;
import com.bupt.se.homework.dao.BasicDao;
import com.bupt.se.homework.dao.CourseDAO;
import com.bupt.se.homework.entity.Course;
import com.bupt.se.homework.entity.Homework;
import com.bupt.se.homework.entity.Student;
import com.bupt.se.homework.entity.StudentCourse;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

/**
 * @description: CourseBo 实现类
 * @author: zh
 * @create: 2018-11-15 16:38
 **/
public class CourseBoImpl extends BasicBoImpl<Course, String> implements CourseBo {

    private CourseDAO courseDAO;

    @Autowired
    public void setCourseDAO(BasicDao<Course, String> basicDao) {
        super.setBasicDao(basicDao);
        this.courseDAO = (CourseDAO) basicDao;
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
                countPerTenScore[sc.getGrade() / 10]++;
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
}
