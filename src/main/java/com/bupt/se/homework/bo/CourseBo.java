package com.bupt.se.homework.bo;

import com.bupt.se.homework.entity.Course;
import com.bupt.se.homework.entity.Student;
import com.bupt.se.homework.entity.StudentCourse;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface CourseBo extends BasicBo<Course, String> {

    Set<StudentCourse> getStudentCourse(Course course);

    List<Student> getStudents(Course course);

    Map<String, Object> getStatistics(Course course);

    void addCourse(Course course);

    List<Course> listCourse();
}
