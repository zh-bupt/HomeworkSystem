package com.bupt.se.homework.bo.impl;

import com.bupt.se.homework.bo.TeacherBo;
import com.bupt.se.homework.dao.TeacherDAO;
import com.bupt.se.homework.entity.Teacher;

import java.util.List;

public class TeacherBoImpl implements TeacherBo {

    TeacherDAO teacherDAO;// = new TeacherDAOImpl();

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
}
