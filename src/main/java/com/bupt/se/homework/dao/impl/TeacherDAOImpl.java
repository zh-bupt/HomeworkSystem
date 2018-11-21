package com.bupt.se.homework.dao.impl;

import com.bupt.se.homework.dao.TeacherDAO;
import com.bupt.se.homework.entity.Teacher;
import org.springframework.stereotype.Repository;

@Repository("teacherDAO")
public class TeacherDAOImpl extends BasicDAOImpl<Teacher, String> implements TeacherDAO {

}
