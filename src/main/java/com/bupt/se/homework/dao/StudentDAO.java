package com.bupt.se.homework.dao;

import com.bupt.se.homework.entity.Homework;
import com.bupt.se.homework.entity.HomeworkGroup;
import com.bupt.se.homework.entity.Student;

public interface StudentDAO extends BasicDao<Student, String> {

    HomeworkGroup getHomeworkGroup(Student student, Homework homework);


}
