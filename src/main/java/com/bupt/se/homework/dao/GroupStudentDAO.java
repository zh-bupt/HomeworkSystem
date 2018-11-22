package com.bupt.se.homework.dao;

import com.bupt.se.homework.entity.Student;
import com.bupt.se.homework.entity.Group_;

import java.util.List;

import java.util.List;

public interface GroupStudentDAO{

    public List<Student> findResultList(String courseID);
}
