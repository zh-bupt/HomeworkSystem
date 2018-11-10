package com.bupt.se.homework.dao;

import com.bupt.se.homework.entity.Teacher;

import java.util.List;

public interface TeacherDAO {
    void addTeacher(Teacher teacher);
    List<Teacher> listTeacher();

    Teacher queryById(String id);
}
