package com.bupt.se.homework.bo;

import com.bupt.se.homework.entity.Course;
import com.bupt.se.homework.entity.Group_;
import com.bupt.se.homework.entity.Student;

import java.util.Set;

public interface GroupBo extends BasicBo<Group_, String> {
    void calculateScore(Group_ group_);

    void addGroup(Group_ group_, Course course, Student leader, Set<Student> members) throws Exception;
}
