package com.bupt.se.homework.bo.impl;

import com.bupt.se.homework.bo.HomeworkBo;
import com.bupt.se.homework.dao.BasicDao;
import com.bupt.se.homework.dao.HomeworkDAO;
import com.bupt.se.homework.entity.Homework;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @ClassName: HomeworkBoImpl
 * @Description: TODO
 * @Author: kwong
 * @Create: 2018/11/11 20:26
 **/
@Service("homeworkBo")
public class HomeworkBoImpl extends BasicBoImpl<Homework, Integer> implements HomeworkBo {
    HomeworkDAO homeworkDAO;

    @Autowired
    @Qualifier("homeworkDAO")
    public void setHomeworkDAO(BasicDao<Homework, Integer> basicDao) {
        super.setBasicDao(basicDao);
        this.homeworkDAO = (HomeworkDAO) basicDao;
    }

    @Override
    public boolean addHomework(Homework homework) {
        return this.save(homework);
    }

    @Override
    public boolean updateHomework(Homework homework) {
        return this.update(homework);
    }

    @Override
    public boolean getHomework(int homeworkId) {
        return this.getHomework(homeworkId);
    }
}
