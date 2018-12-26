package com.bupt.se.homework.bo.impl;

import com.bupt.se.homework.bo.HomeworkBo;
import com.bupt.se.homework.dao.BasicDao;
import com.bupt.se.homework.dao.HomeworkDAO;
import com.bupt.se.homework.entity.Course;
import com.bupt.se.homework.entity.Homework;
import com.bupt.se.homework.exception.ServiceException;
import com.bupt.se.homework.exception.ServiceExceptionErrorCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName: HomeworkBoImpl
 * @Description: 作业业务层
 * @Author: zh
 * @Create: 2018/11/11 20:26
 **/
@Service("homeworkBo")
@Transactional
public class HomeworkBoImpl extends BasicBoImpl<Homework, Integer> implements HomeworkBo {
    HomeworkDAO homeworkDAO;

    @Autowired
    @Qualifier("homeworkDAO")
    public void setHomeworkDAO(BasicDao<Homework, Integer> basicDao) {
        super.setBasicDao(basicDao);
        this.homeworkDAO = (HomeworkDAO) basicDao;
    }

    @Override
    @Transactional(noRollbackFor = {ServiceException.class})
    public void updateHomework(Homework homework) throws Exception {
        if (!this.exists(homework.getHomeworkId())) {
            throw new ServiceException(ServiceExceptionErrorCode.HOMEWORK_NOT_FOUND,
                    "作业 " + homework.getHomeworkId() + " 不存在.");
        }
        if (homework.getPercentage() < 0) {
            throw new ServiceException(ServiceExceptionErrorCode.HOMEWORK_PERCENTAGE_ERROR,
                    "作业 " + homework.getHomeworkId() + " 百分比太低, 请设置大于等于0的数值.");
        }
        Course c = homework.getCourse();
        List<Homework> homeworkList = c.getHomework();
        int currentPercentage = homework.getPercentage();
        for (Homework h:homeworkList) {
            if (h.getHomeworkId() != homework.getHomeworkId()) {
                currentPercentage += h.getPercentage();
            }
        }
        if (currentPercentage > 100) {
            throw new ServiceException(ServiceExceptionErrorCode.HOMEWORK_PERCENTAGE_EXCEED,
                    "课程 " + c.getCourseId() + " 作业比例超过100%. 请重新设置作业比例.");
        }
        this.merge(homework);
        logger.info("Update homework: " + homework.getHomeworkId());
    }

    @Override
    @Transactional(readOnly = true, noRollbackFor = {ServiceException.class})
    public Homework getHomework(int homeworkId) {
        return this.get(homeworkId);
    }
}
