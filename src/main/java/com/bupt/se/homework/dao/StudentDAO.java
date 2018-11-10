package com.bupt.se.homework.dao;

import com.bupt.se.homework.entity.Student;

public interface StudentDAO {
    void addStudent(Student student);

    Student queryById(String id);
}
