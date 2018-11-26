package com.bupt.se.homework.bo;

import com.bupt.se.homework.entity.GroupStudent;
import com.bupt.se.homework.entity.GroupStudentPK;
import com.bupt.se.homework.entity.Student;

import java.util.List;

public interface GroupStudentBo extends BasicBo<GroupStudent, GroupStudentPK> {
    void calculateScore();
    public List<Student> findResultList(String courseID);

    }
