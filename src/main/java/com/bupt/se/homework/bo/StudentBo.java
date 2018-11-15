package com.bupt.se.homework.bo;

import com.bupt.se.homework.entity.Course;
import com.bupt.se.homework.entity.Student;
import com.bupt.se.homework.entity.StudentCourse;

import java.util.List;
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
}
