package com.bupt.se.homework.dao;

import com.bupt.se.homework.entity.GroupStudent;
import com.bupt.se.homework.entity.GroupStudentPK;
import com.bupt.se.homework.entity.Student;
import com.bupt.se.homework.entity.Group_;


import java.util.List;

public interface GroupStudentDAO extends BasicDao<GroupStudent, GroupStudentPK> {

    List<Student> findResultList(String courseID);

    void setContribution(Group_ g, Student s, int contribution);
}
