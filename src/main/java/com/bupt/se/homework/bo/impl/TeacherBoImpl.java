package com.bupt.se.homework.bo.impl;

import com.bupt.se.homework.bo.ReturnCode;
import com.bupt.se.homework.bo.TeacherBo;
import com.bupt.se.homework.dao.TeacherDAO;
import com.bupt.se.homework.entity.Teacher;

import java.util.List;

/**
 * @Description: Teacher 业务逻辑实现类
 * @Author: zh
 * @Date: 2018/11/10
 **/
public class TeacherBoImpl implements TeacherBo {

    TeacherDAO teacherDAO;

    public void setTeacherDAO(TeacherDAO teacherDAO){
        this.teacherDAO = teacherDAO;
    }

    @Override
    public boolean addTeacher(Teacher teacher) {
        return teacherDAO.save(teacher);
    }

    @Override
    public boolean updateTeacher(Teacher teacher) {
        return teacherDAO.update(teacher);
    }

    @Override
    public boolean deleteTeacher(String id) {
        return teacherDAO.delete(id);
    }

    @Override
    public List<Teacher> listTeacher() {
        return teacherDAO.findResultList(null, null, null, null, null, null, 0, 0);
    }

    @Override
    public String login(String id, String password) {
        Teacher teacher = teacherDAO.get(id);
        if (teacher == null) return ReturnCode.USER_NOT_FOUNT;
        if (!teacher.getPassword().equals(password)) return ReturnCode.WRONG_PASSWORD;
        return ReturnCode.LOGIN_SUCCESS;
    }
}
