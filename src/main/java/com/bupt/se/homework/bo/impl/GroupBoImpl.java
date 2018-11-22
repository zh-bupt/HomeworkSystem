package com.bupt.se.homework.bo.impl;

import com.bupt.se.homework.bo.BasicBo;
import com.bupt.se.homework.bo.GroupBo;
import com.bupt.se.homework.dao.BasicDao;
import com.bupt.se.homework.dao.GroupDAO;
import com.bupt.se.homework.entity.Group_;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: zh
 * @create: 2018-11-16 15:07
 **/
@Service("groupBo")
public class GroupBoImpl extends BasicBoImpl<Group_, String> implements GroupBo {
    private GroupDAO groupDAO;

    @Autowired
    @Qualifier("groupDAO")
    public void setGroupDAO(BasicDao<Group_,String>basicDao){
        super.setBasicDao(basicDao);
        this.groupDAO = (GroupDAO)basicDao;
    }
}
