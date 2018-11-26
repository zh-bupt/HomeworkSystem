package com.bupt.se.homework.bo.impl;

import com.bupt.se.homework.bo.GroupStudentBo;
import com.bupt.se.homework.dao.BasicDao;
import com.bupt.se.homework.dao.GroupStudentDAO;
import com.bupt.se.homework.entity.GroupStudent;
import com.bupt.se.homework.entity.GroupStudentPK;
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

    @Override
    public List<Student> findResultList(String courseID) {
        return groupStudentDAO.findResultList(courseID);
    }
}
