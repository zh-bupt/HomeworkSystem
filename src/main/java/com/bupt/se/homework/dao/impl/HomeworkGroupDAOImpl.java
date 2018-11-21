package com.bupt.se.homework.dao.impl;

import com.bupt.se.homework.dao.HomeworkGroupDAO;
import com.bupt.se.homework.entity.HomeworkGroup;
import com.bupt.se.homework.entity.HomeworkGroupPK;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @description:
 * @author: zh
 * @create: 2018-11-16 14:27
 **/
@Repository("homeworkGroupDAO")
@Transactional
public class HomeworkGroupDAOImpl
        extends BasicDAOImpl<HomeworkGroup, HomeworkGroupPK> implements HomeworkGroupDAO {
}
