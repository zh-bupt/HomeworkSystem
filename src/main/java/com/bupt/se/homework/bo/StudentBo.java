package com.bupt.se.homework.bo;

import com.bupt.se.homework.entity.Student;

import java.util.List;

public interface StudentBo {

    boolean addStudent(Student student);

    boolean deleteStudent(String id);

    boolean updateStudent(Student student);

    List<Student> getStudentsByClass(String classId);

    List<Student> getStudentsByName(String name);


    String login(String id, String password);
}
