package com.bupt.se.homework.bo;

import com.bupt.se.homework.entity.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface StudentBo extends BasicBo<Student, String> {

    boolean addStudent(Student student);

    boolean deleteStudent(String id);

    boolean updateStudent(Student student);

    List<Student> getStudentsByClass(String classId);

    List<Student> getStudentsByName(String name);

    Set<StudentCourse> getStudentCourse(Student student);

    List<Course> getCourseList(Student student);

    String login(String id, String password);

    Map<Course, Integer> getTranscript(String studentId);

    List<Homework> getHomeworkList(String studentId, String courseId);

    Group_ getCourseGroup(String studentId, String courseId);

    List<Group_> getManagedGroups(String studentId);

    HomeworkGroup getHomeworkGroup(Student student, Homework homework);
}
