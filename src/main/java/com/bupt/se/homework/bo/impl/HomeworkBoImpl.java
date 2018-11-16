package com.bupt.se.homework.bo.impl;

import com.bupt.se.homework.bo.HomeworkBo;
import com.bupt.se.homework.dao.HomeworkDAO;
import com.bupt.se.homework.dao.impl.HomeworkDAOImpl;
import com.bupt.se.homework.entity.Homework;

/**
 * @ClassName: HomeworkBoImpl
 * @Description: TODO
 * @Author: kwong
 * @Create: 2018/11/11 20:26
 **/

public class HomeworkBoImpl implements HomeworkBo {
    HomeworkDAO homeworkDAO;
    public void setHomeworkDAO(HomeworkDAOImpl homeworkDAO) {
        this.homeworkDAO = homeworkDAO;
    }

    @Override
    public void addHomework(Homework homework) {
        //TODO BY ZH
    }
}
