package com.bupt.se.homework.bo.impl;

import com.bupt.se.homework.bo.HomeworkBo;
import com.bupt.se.homework.dao.BasicDao;
import com.bupt.se.homework.dao.HomeworkDAO;
import com.bupt.se.homework.entity.Homework;
import com.bupt.se.homework.exception.ServiceException;
import com.bupt.se.homework.exception.ServiceExceptionErrorCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @ClassName: HomeworkBoImpl
 * @Description: 作业业务层
 * @Author: zh
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

//    @Override
//    public void addHomework(Homework homework) throws Exception {
//        this.save(homework);
//    }

    @Override
    public void updateHomework(Homework homework) throws Exception {
        if (!this.exists(homework.getHomeworkId())) {
            throw new ServiceException(ServiceExceptionErrorCode.HOMEWORK_NOT_FOUND,
                    "作业 " + homework.getHomeworkId() + " 不存在.");
        }
        this.update(homework);
    }

    @Override
    public Homework getHomework(int homeworkId) {
        return this.getHomework(homeworkId);
    }
}
