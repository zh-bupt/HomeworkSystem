package com.bupt.se.homework.bo.impl;

import com.bupt.se.homework.bo.GroupStudentBo;
import com.bupt.se.homework.dao.BasicDao;
import com.bupt.se.homework.dao.GroupStudentDAO;
import com.bupt.se.homework.entity.GroupStudent;
import com.bupt.se.homework.entity.GroupStudentPK;
import org.springframework.stereotype.Service;

/**
 * @description: group student 实现类
 * @author: zh
 * @create: 2018-11-22 15:53
 **/
@Service
public class GroupStudentBoImpl
        extends BasicBoImpl<GroupStudent, GroupStudentPK>
        implements GroupStudentBo {

    private GroupStudentDAO groupStudentDAO;

    public void setGroupStudentDAO(BasicDao<GroupStudent, GroupStudentPK> basicDao) {
        super.setBasicDao(basicDao);
        this.groupStudentDAO = (GroupStudentDAO) basicDao;
    }

    @Override
    public void calculateScore() {

    }
}
