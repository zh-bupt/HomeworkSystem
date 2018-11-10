package com.bupt.se.homework.bo;

import com.bupt.se.homework.entity.Teacher;

import java.util.List;

public interface TeacherBo {

    void addTeacher(Teacher teacher);
    List<Teacher> listTeacher();

    String login(String account, String password);
}
