package com.bupt.se.homework.bo;

import com.bupt.se.homework.entity.GroupStudent;
import com.bupt.se.homework.entity.GroupStudentPK;

public interface GroupStudentBo extends BasicBo<GroupStudent, GroupStudentPK> {
    void calculateScore();

    void updateGroupStudent(GroupStudent groupStudent) throws Exception;
}
