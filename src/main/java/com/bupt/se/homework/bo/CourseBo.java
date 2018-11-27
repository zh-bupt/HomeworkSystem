package com.bupt.se.homework.bo;

import com.bupt.se.homework.entity.Course;
import com.bupt.se.homework.entity.Homework;
import com.bupt.se.homework.entity.Student;
import com.bupt.se.homework.entity.StudentCourse;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface CourseBo extends BasicBo<Course, String> {

//    Set<StudentCourse> getStudentCourse(Course course);

    List<Student> getStudentList(String courseId) throws Exception;

    Map<String, Object> getStatistics(Course course);

    void addCourse(Course course) throws Exception;

    List<Course> listCourse();

    List<Homework> listHomework(String courseId) throws Exception;

    void calculateScore(String courseId) throws Exception;
}
