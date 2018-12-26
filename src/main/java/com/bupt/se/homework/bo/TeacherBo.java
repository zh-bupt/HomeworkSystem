package com.bupt.se.homework.bo;

import com.bupt.se.homework.entity.Course;
import com.bupt.se.homework.entity.Homework;
import com.bupt.se.homework.entity.Student;
import com.bupt.se.homework.entity.Teacher;

import java.util.List;
import java.util.Map;


public interface TeacherBo extends BasicBo<Teacher, String> {


    void addTeacher(Teacher teacher) throws Exception;

    void updateTeacher(Teacher teacher) throws Exception;

    void deleteTeacher(String id) throws Exception;

    List<Teacher> listTeacher();

    List<Course> getCourseSet(Teacher teacher);

    String login(String id, String password);

    Map<Student, List<Double>> getCourseTranscript(String teacherId, String courseId) throws Exception;

    void assignHomework(String courseId, Homework homework) throws Exception;
}