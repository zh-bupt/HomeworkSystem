package com.bupt.se.homework.dao;

import com.bupt.se.homework.entity.Course;
import com.bupt.se.homework.entity.Homework;
import com.bupt.se.homework.entity.Teacher;

public interface  TeacherDAO extends BasicDao<Teacher, String> {

    int AssignHomework(Course course, Homework homework);
}
