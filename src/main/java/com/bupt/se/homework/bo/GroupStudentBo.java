package com.bupt.se.homework.bo;

import com.bupt.se.homework.entity.GroupStudent;
import com.bupt.se.homework.entity.GroupStudentPK;
import com.bupt.se.homework.entity.Student;

import java.util.List;

public interface GroupStudentBo extends BasicBo<GroupStudent, GroupStudentPK> {
    void calculateScore();

    void updateGroupStudent(GroupStudent groupStudent) throws Exception;

    List<Student> findLeftStudentList(String courseID);

    void setContribution(String groupId, String studentId, int contribution) throws Exception;

}
