package com.bupt.se.homework.bo;

import com.bupt.se.homework.entity.Student;

public interface StudentBo {
    void addStudent(Student student);

    String login(String account, String password);
}
