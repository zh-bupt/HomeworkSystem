package com.bupt.se.homework.bo.impl;

import com.bupt.se.homework.bo.GroupStudentBo;
import com.bupt.se.homework.dao.BasicDao;
import com.bupt.se.homework.dao.GroupStudentDAO;
import com.bupt.se.homework.entity.GroupStudent;
import com.bupt.se.homework.entity.GroupStudentPK;
import com.bupt.se.homework.exception.ServiceException;
import com.bupt.se.homework.exception.ServiceExceptionErrorCode;
import com.bupt.se.homework.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description: group student 实现类
 * @author: zh
 * @create: 2018-11-22 15:53
 **/
@Service("groupStudentBo")
public class GroupStudentBoImpl
        extends BasicBoImpl<GroupStudent, GroupStudentPK>
        implements GroupStudentBo {

    private GroupStudentDAO groupStudentDAO;

    @Autowired
    @Qualifier("groupStudentDAO")
    public void setGroupStudentDAO(BasicDao<GroupStudent, GroupStudentPK> basicDao) {
        super.setBasicDao(basicDao);
        this.groupStudentDAO = (GroupStudentDAO) basicDao;
    }

    @Override
    public void calculateScore() {

    }

    /**
     * @Description: 更新学生小组信息(组长打分用)
     * @param groupStudent
     * @return: void
     * @Author: zh
     * @Date: 2018/11/27
     **/
    @Override
    public void updateGroupStudent(GroupStudent groupStudent) throws Exception {
        if (!this.exists(groupStudent.getPk())){
            throw new ServiceException(ServiceExceptionErrorCode.GROUP_STUDENT_NOT_FOUND,
                    "学生不在小组内.");
        }
        if (groupStudent.getContribution() > 100 || groupStudent.getContribution() < 0) {
            throw new ServiceException(ServiceExceptionErrorCode.GROUP_STUDENT_CONTRIBUTION_ERROR,
                    "学生贡献值错误.");
        }
        this.update(groupStudent);
    }

    @Override
    public List<Student> findResultList(String courseID) {
        return groupStudentDAO.findResultList(courseID);
    }
}
