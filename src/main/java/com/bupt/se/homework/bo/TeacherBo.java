package com.bupt.se.homework.bo;

import com.bupt.se.homework.entity.Teacher;

import java.util.List;

public interface TeacherBo {

    boolean addTeacher(Teacher teacher);

    boolean updateTeacher(Teacher teacher);

    boolean deleteTeacher(String id);

    List<Teacher> listTeacher();

    String login(String id, String password);
}
