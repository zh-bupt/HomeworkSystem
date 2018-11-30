package com.bupt.se.homework.bo.impl;

import com.bupt.se.homework.bo.HomeworkGroupBo;
import com.bupt.se.homework.dao.BasicDao;
import com.bupt.se.homework.dao.HomeworkGroupDAO;
import com.bupt.se.homework.entity.HomeworkGroup;
import com.bupt.se.homework.entity.HomeworkGroupPK;
import com.bupt.se.homework.exception.ServiceException;
import com.bupt.se.homework.exception.ServiceExceptionErrorCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @description:
 * @author: zh
 * @create: 2018-11-16 14:27
 **/
@Service("homeworkGroupBo")
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

    /**
     * @Description: 修改HomeworkGroup(老师打分, 写评论用)
     * @param homeworkGroup
     * @return: void
     * @Author: zh
     * @Date: 2018/11/27
     **/
    @Override
    @Transactional(noRollbackFor = {ServiceException.class})
    public void updateHomeworkGroup(HomeworkGroup homeworkGroup) throws Exception {
        if (!this.exists(homeworkGroup.getPk())){
            throw new ServiceException(ServiceExceptionErrorCode.HOMEWORK_GROUP_NOT_FOUND,
                    "作业小组不存在.");
        }
        if (homeworkGroup.getScore() > 100 || homeworkGroup.getScore() < 0) {
            throw new ServiceException(ServiceExceptionErrorCode.HOMEWORK_GROUP_SCORE_ERROR,
                    "作业分数错误.");
        }
        this.update(homeworkGroup);
        logger.info("Updated HomeworkGroup " + homeworkGroup.getPk());
    }
}
