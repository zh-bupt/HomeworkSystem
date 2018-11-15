package com.bupt.se.homework.bo.impl;

import com.bupt.se.homework.bo.ReturnCode;
import com.bupt.se.homework.bo.TeacherBo;
import com.bupt.se.homework.dao.BasicDao;
import com.bupt.se.homework.dao.TeacherDAO;
import com.bupt.se.homework.entity.Course;
import com.bupt.se.homework.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Set;

/**
 * @Description: Teacher 业务逻辑实现类
 * @Author: zh
 * @Date: 2018/11/10
 **/
public class TeacherBoImpl extends BasicBoImpl<Teacher, String> implements TeacherBo {

    TeacherDAO teacherDAO;

    @Autowired
    public void setTeacherDAO(BasicDao<Teacher, String> basicDao){
        super.setBasicDao(basicDao);
        this.teacherDAO = (TeacherDAO) basicDao;
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
    public Set<Course> getCourseSet(Teacher teacher) {
        return teacher.getCourses();
    }

    @Override
    public String login(String id, String password) {
        Teacher teacher = teacherDAO.get(id);
        if (teacher == null) return ReturnCode.USER_NOT_FOUNT;
        if (!teacher.getPassword().equals(password)) return ReturnCode.WRONG_PASSWORD;
        return ReturnCode.LOGIN_SUCCESS;
    }
}
