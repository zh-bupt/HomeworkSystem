package com.bupt.se.homework.bo.impl;

import com.bupt.se.homework.bo.HomeworkGroupBo;
import com.bupt.se.homework.dao.BasicDao;
import com.bupt.se.homework.dao.HomeworkGroupDAO;
import com.bupt.se.homework.entity.HomeworkGroup;
import com.bupt.se.homework.entity.HomeworkGroupPK;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @description:
 * @author: zh
 * @create: 2018-11-16 14:27
 **/
@Service
@Transactional
public class HomeworkGroupBoImpl
        extends BasicBoImpl<HomeworkGroup, HomeworkGroupPK>
        implements HomeworkGroupBo {

    private HomeworkGroupDAO homeworkGroupDAO;

    @Autowired
    @Qualifier("homeworkGroupDAO")
    public void setHomeworkGroupDAO(BasicDao<HomeworkGroup, HomeworkGroupPK> basicDao) {
        super.setBasicDao(basicDao);
        this.homeworkGroupDAO = (HomeworkGroupDAO) basicDao;
    }
}
