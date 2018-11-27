package com.bupt.se.homework.bo;

import com.bupt.se.homework.entity.*;

import java.util.List;
import java.util.Map;

public interface StudentBo extends BasicBo<Student, String> {

    void addStudent(Student student) throws Exception;

    void deleteStudent(String id) throws Exception;

    void updateStudent(Student student) throws Exception;

    List<Student> getStudentsByClass(String classId);

    List<Student> getStudentsByName(String name);

    List<StudentCourse> getStudentCourse(Student student);

    List<Course> getCourseList(Student student);

    String login(String id, String password);

    Map<Course, Double> getTranscript(String studentId) throws Exception;

    List<Homework> getHomeworkList(String studentId, String courseId);

    Group_ getCourseGroup(String studentId, String courseId);

    List<Group_> getManagedGroups (String studentId) throws Exception;

    HomeworkGroup getHomeworkGroup(Student student, Homework homework);
}
