package com.bupt.se.homework.bo.impl;

import com.bupt.se.homework.bo.GroupStudentBo;
import com.bupt.se.homework.dao.BasicDao;
import com.bupt.se.homework.dao.GroupDAO;
import com.bupt.se.homework.dao.GroupStudentDAO;
import com.bupt.se.homework.dao.StudentDAO;
import com.bupt.se.homework.entity.GroupStudent;
import com.bupt.se.homework.entity.GroupStudentPK;
import com.bupt.se.homework.entity.Group_;
import com.bupt.se.homework.exception.ServiceException;
import com.bupt.se.homework.exception.ServiceExceptionErrorCode;
import com.bupt.se.homework.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @description: group student 实现类
 * @author: zh
 * @create: 2018-11-22 15:53
 **/
@Service("groupStudentBo")
@Transactional
public class GroupStudentBoImpl
        extends BasicBoImpl<GroupStudent, GroupStudentPK>
        implements GroupStudentBo {

    private GroupStudentDAO groupStudentDAO;
    private GroupDAO groupDAO;
    private StudentDAO studentDAO;

    @Autowired
    @Qualifier("groupStudentDAO")
    public void setGroupStudentDAO(BasicDao<GroupStudent, GroupStudentPK> basicDao) {
        super.setBasicDao(basicDao);
        this.groupStudentDAO = (GroupStudentDAO) basicDao;
    }

    @Autowired
    public void setGroupDAO(GroupDAO groupDAO) {
        this.groupDAO = groupDAO;
    }

    @Autowired
    public void setStudentDAO(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
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
    @Transactional(noRollbackFor = {ServiceException.class})
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
//<<<<<<< HEAD
    public List<Student> findLeftStudentList(String courseID) {
        return groupStudentDAO.findLeftStudentList(courseID);
//=======
//    @Transactional
//    public List<Student> findResultList(String courseID) {
//        return groupStudentDAO.findResultList(courseID);
//>>>>>>> e957788ae66d5c217a5c28b8dbfff4538e85fd4a
    }

    @Override
    @Transactional(noRollbackFor = {ServiceException.class})
    public void setContribution(String groupId, String studentId, int contribution) throws Exception {
        Group_ g = groupDAO.get(groupId);
        if (contribution < 0 || contribution > 100) {
            throw new ServiceException(ServiceExceptionErrorCode.GROUP_STUDENT_CONTRIBUTION_ERROR,
                    "学生贡献值错误.");
        }
        if (g == null) {
            throw new ServiceException(ServiceExceptionErrorCode.GROUP_NOT_FOUND,
                    "小组 " + groupId + " 不存在.");
        }
        Student s = studentDAO.get(studentId);
        if (s == null) {
            throw new ServiceException(ServiceExceptionErrorCode.GROUP_NOT_FOUND,
                    "学生 " + studentId + " 不存在.");
        }
        GroupStudentPK pk = new GroupStudentPK(g.getGroupId(), s.getStudentId());
        GroupStudent gs = groupStudentDAO.get(pk);
        if (gs == null) {
            throw new ServiceException(ServiceExceptionErrorCode.NOT_IN_GROUP,
                    "学生 " + studentId + " 不在小组 " + groupId);
        }
        groupStudentDAO.setContribution(g, s, contribution);
        logger.info("Update GroupStudent: " + groupId + ", " + studentId);
    }
}
