package com.bupt.se.homework.dao;

import com.bupt.se.homework.entity.*;

public interface StudentDAO extends BasicDao<Student, String> {

    HomeworkGroup getHomeworkGroup(Student student, Homework homework);

    Group_ getCourseGroup(Student student, Course course);
}
