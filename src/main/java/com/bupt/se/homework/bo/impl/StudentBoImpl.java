package com.bupt.se.homework.bo.impl;

import com.bupt.se.homework.bo.StudentBo;
import com.bupt.se.homework.dao.StudentDAO;
import com.bupt.se.homework.entity.Student;

public class StudentBoImpl implements StudentBo {
    StudentDAO studentDAO;

    public StudentDAO getStudentDAO() {
        return studentDAO;
    }

    public void setStudentDAO(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @Override
    public void addStudent(Student student) {
        studentDAO.addStudent(student);
    }
}
