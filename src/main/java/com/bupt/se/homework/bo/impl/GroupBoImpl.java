package com.bupt.se.homework.bo.impl;

import com.bupt.se.homework.bo.GroupBo;
import com.bupt.se.homework.dao.BasicDao;
import com.bupt.se.homework.dao.GroupDAO;
import com.bupt.se.homework.entity.*;
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

    /**
     * @Description: 计算小组的成绩
     * @param group_
     * @return: void
     * @Author: zh
     * @Date: 2018/11/25
     **/
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

    @Override
    public void addGroup(Group_ group_, Course course, Student leader, Set<Student> members) {
        group_.setCourse(course);
        group_.setLeader(leader);
        Set<Homework> homeworkSet = course.getHomework();
        if (homeworkSet != null && homeworkSet.size() > 0) {
            for (Homework h:homeworkSet) {
                HomeworkGroup hg = new HomeworkGroup(h, group_);
                group_.getHomeworkGroups().add(hg);
            }
        }
        if (members != null && members.size() > 0) {
            for (Student s:members) {
                GroupStudent gs = new GroupStudent(group_, s);
                group_.getGroupStudentSet().add(gs);
            }
        }
        this.merge(group_);
    }
}
