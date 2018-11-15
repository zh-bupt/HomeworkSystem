package com.bupt.se.homework.bo;

import com.bupt.se.homework.entity.Course;
import com.bupt.se.homework.entity.Teacher;

import java.util.List;
import java.util.Set;

public interface TeacherBo {

    boolean addTeacher(Teacher teacher);

    boolean updateTeacher(Teacher teacher);

    boolean deleteTeacher(String id);

    List<Teacher> listTeacher();

    Set<Course> getCourseSet(Teacher teacher);

    String login(String id, String password);
}
