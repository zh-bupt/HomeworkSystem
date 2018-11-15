package com.bupt.se.homework.bo.impl;

import com.bupt.se.homework.bo.CourseBo;
import com.bupt.se.homework.dao.CourseDAO;
import com.bupt.se.homework.dao.impl.CourseDAOImpl;
import com.bupt.se.homework.entity.Course;

import java.util.List;

/**
 * @ClassName: CourseBoImpl
 * @Description: TODO
 * @Author: kwong
 * @Create: 2018/11/11 18:36
 **/

public class CourseBoImpl implements CourseBo {
    private CourseDAO courseDAO;

    @Override
    public void addCourse(Course course) {
        //TODO By ZH
    }

    @Override
    public List<Course> listCourse() {
        //TODO BY ZH
        return null;
    }

    public void setCourseDAO(CourseDAOImpl courseDAO) {
        this.courseDAO = courseDAO;
    }
}
