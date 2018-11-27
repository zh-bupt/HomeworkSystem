package com.bupt.se.homework.bo;

import com.bupt.se.homework.entity.Course;
import com.bupt.se.homework.entity.Homework;
import com.bupt.se.homework.entity.Student;
import com.bupt.se.homework.entity.Teacher;

import java.util.List;
import java.util.Map;


public interface TeacherBo extends BasicBo<Teacher, String> {


    boolean addTeacher(Teacher teacher);

    boolean updateTeacher(Teacher teacher);

    boolean deleteTeacher(String id);

    List<Teacher> listTeacher();

    List<Course> getCourseSet(Teacher teacher);

    String login(String id, String password);

    Map<Student, Double> getCourseTranscript(String teacherId, String courseId);

    int AssignHomework(Course course, Homework homework);
}