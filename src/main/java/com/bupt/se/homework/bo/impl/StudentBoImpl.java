package com.bupt.se.homework.bo.impl;

import com.bupt.se.homework.bo.ReturnCode;
import com.bupt.se.homework.bo.StudentBo;
import com.bupt.se.homework.dao.BasicDao;
import com.bupt.se.homework.dao.StudentDAO;
import com.bupt.se.homework.entity.Student;

import java.util.LinkedHashMap;
import java.util.List;

public class StudentBoImpl implements StudentBo {
    StudentDAO studentDAO;

    public void setStudentDAO(BasicDao<Student, String> studentDAO) {
        this.studentDAO = (StudentDAO) studentDAO;
    }

    @Override
    public boolean addStudent(Student student) {
        return studentDAO.save(student);
    }

    @Override
    public boolean deleteStudent(String id) {
        return studentDAO.delete(id);
    }

    @Override
    public boolean updateStudent(Student student) {
        return studentDAO.update(student);
    }

    @Override
    public List<Student> getStudentsByClass(String classId) {
        LinkedHashMap<Object, Object> equals = new LinkedHashMap<>();
        equals.put("classId", classId);
        return studentDAO.findResultList(equals, null, null, null, null, null, 0, 0);
    }

    @Override
    public List<Student> getStudentsByName(String name) {
        LinkedHashMap<Object, Object> equals = new LinkedHashMap<>();
        equals.put("studentName", name);
        return studentDAO.findResultList(equals, null, null, null, null, null, 0, 0);
    }

    @Override
    public String login(String id, String password) {
        Student student = studentDAO.get(id);
        if (student == null) return ReturnCode.USER_NOT_FOUNT;
        if (!student.getPassword().equals(password)) return ReturnCode.WRONG_PASSWORD;
        if (student.getPassword().equals(student.getStudentId())) return ReturnCode.FIRST_LOGIN;
        return ReturnCode.LOGIN_SUCCESS;
    }
}
