package com.bupt.se.homework.bo.impl;

import com.bupt.se.homework.bo.HomeworkGroupBo;
import com.bupt.se.homework.dao.BasicDao;
import com.bupt.se.homework.dao.HomeworkGroupDAO;
import com.bupt.se.homework.entity.HomeworkGroup;
import com.bupt.se.homework.entity.HomeworkGroupPK;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @description:
 * @author: zh
 * @create: 2018-11-16 14:27
 **/
public class HomeworkGroupBoImpl
        extends BasicBoImpl<HomeworkGroup, HomeworkGroupPK>
        implements HomeworkGroupBo {

    private HomeworkGroupDAO homeworkGroupDAO;

    @Autowired
    public void setHomeworkGroupDAO(BasicDao<HomeworkGroup, HomeworkGroupPK> basicDao) {
        super.setBasicDao(basicDao);
        this.homeworkGroupDAO = (HomeworkGroupDAO) basicDao;
    }
}
