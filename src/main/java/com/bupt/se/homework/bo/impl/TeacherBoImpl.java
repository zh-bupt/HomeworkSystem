package com.bupt.se.homework.bo.impl;

import com.bupt.se.homework.bo.ReturnCode;
import com.bupt.se.homework.bo.TeacherBo;
import com.bupt.se.homework.dao.TeacherDAO;
import com.bupt.se.homework.entity.Admin;
import com.bupt.se.homework.entity.Teacher;

import java.util.List;

public class TeacherBoImpl implements TeacherBo {

    TeacherDAO teacherDAO;

    //DI via Spring
    public void setTeacherDAO(TeacherDAO teacherDAO){
        this.teacherDAO = teacherDAO;
    }
    //call DAO to save hwsystem
    @Override
    public void addTeacher(Teacher teacher) {
        teacherDAO.addTeacher(teacher);
    }

    @Override
    public List<Teacher> listTeacher() {
        return teacherDAO.listTeacher();

    }

    @Override
    public String login(String id, String password) {
        Teacher teacher = teacherDAO.queryById(id);
        if (teacher == null) return ReturnCode.USER_NOT_FOUNT;
        if (!teacher.getPassword().equals(password)) return ReturnCode.WRONG_PASSWORD;
        return ReturnCode.LOGIN_SUCCESS;
    }
}
