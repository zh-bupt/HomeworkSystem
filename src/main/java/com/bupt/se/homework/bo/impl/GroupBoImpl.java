package com.bupt.se.homework.bo.impl;

import com.bupt.se.homework.bo.GroupBo;
import com.bupt.se.homework.dao.BasicDao;
import com.bupt.se.homework.dao.GroupDAO;
import com.bupt.se.homework.entity.Group_;
import com.bupt.se.homework.entity.HomeworkGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Set;

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
    public void setGroupDAO(BasicDao<Group_, String> basicDao) {
        super.setBasicDao(basicDao);
        this.groupDAO = (GroupDAO) basicDao;
    }

    @Override
    public void calculateScore(Group_ group_) {
        Set<HomeworkGroup> homeworkGroups = group_.getHomeworkGroups();
        if (homeworkGroups != null && homeworkGroups.size() > 0) {
            double score = 0.;
            int temp = 0;
            for (HomeworkGroup hg:homeworkGroups) {
                score += (double)(hg.getScore() * hg.getHomework().getPercentage());
                temp += hg.getHomework().getPercentage();
            }
            group_.setGroupScore(score / (double)(temp));
            groupDAO.update(group_);
        }
    }
}
