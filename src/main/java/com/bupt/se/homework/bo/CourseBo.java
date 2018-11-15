package com.bupt.se.homework.bo;

import com.bupt.se.homework.entity.Course;
import com.bupt.se.homework.entity.Teacher;

import java.util.List;

public interface CourseBo {
    void addCourse(Course course);

    List<Course> listCourse();
}
