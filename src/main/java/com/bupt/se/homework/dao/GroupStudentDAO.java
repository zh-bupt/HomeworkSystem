package com.bupt.se.homework.dao;

import com.bupt.se.homework.entity.Student;
import com.bupt.se.homework.entity.Group;

public interface GroupStudentDAO{

    public List<Student> findResultList(String courseID);
}
