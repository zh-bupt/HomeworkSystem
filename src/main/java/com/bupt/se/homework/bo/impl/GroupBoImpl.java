package com.bupt.se.homework.bo.impl;

import com.bupt.se.homework.bo.GroupBo;
import com.bupt.se.homework.dao.BasicDao;
import com.bupt.se.homework.dao.GroupDAO;
import com.bupt.se.homework.dao.StudentHomeworkDAO;
import com.bupt.se.homework.entity.*;
import com.bupt.se.homework.exception.ServiceException;
import com.bupt.se.homework.exception.ServiceExceptionErrorCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

/**
 * @description:
 * @author: zh
 * @create: 2018-11-16 15:07
 **/
@Service("groupBo")
@Transactional
public class GroupBoImpl extends BasicBoImpl<Group_, String> implements GroupBo {

    private GroupDAO groupDAO;

    @Resource
    private StudentHomeworkDAO studentHomeworkDAO;


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
    @Transactional(noRollbackFor = {ServiceException.class})
    public void calculateScore(Group_ group_) {
//        Group_ group_ = this.get(groupId);
//        if (group_ == null) {
//            throw new ServiceException(ServiceExceptionErrorCode.GROUP_NOT_FOUND, "小组 " + groupId + " 不存在!");
//        }
        List<HomeworkGroup> homeworkGroups = group_.getHomeworkGroups();
        if (homeworkGroups != null && homeworkGroups.size() > 0) {
            double score = 0.;
            int temp = 0;
            for (HomeworkGroup hg:homeworkGroups) {
                score += (double)(hg.getScore() * hg.getHomework().getPercentage());
                temp += hg.getHomework().getPercentage();
                // 计算机每个学生每次作业的成绩
                Homework homework = hg.getHomework();
                List<GroupStudent> groupStudentList = hg.getGroup_().getGroupStudentList();
                for (GroupStudent gs:groupStudentList) {
                    Student student = gs.getStudent();
                    StudentHomework studentHomework = new StudentHomework(homework, student);
                    studentHomework.setScore(hg.getScore());
                    studentHomework.setGroupScore(hg.getScore() * gs.getContribution() / 100.);
                    studentHomeworkDAO.saveOrUpdate(studentHomework);
                }
            }
            group_.setGroupScore(score / (double)(temp));
            groupDAO.update(group_);
        }
    }

    @Override
    @Transactional(noRollbackFor = {ServiceException.class})
    public void addGroup(Group_ group_, Course course, Student leader, Set<Student> members) throws Exception {
//        group_.setGroupId(course.getGroupPrefix() + group_.getGroupId() + group_.getName());
        if (members.size() > course.getMaxStudentNum()) {
            throw new ServiceException(ServiceExceptionErrorCode.GROUP_NUM_ERROR, "小组人数过多!");
        } else if (members.size() < course.getMinStudentNum()) {
            throw new ServiceException(ServiceExceptionErrorCode.GROUP_NUM_ERROR, "小组人数不足!");
        }
        if (groupDAO.exists(group_.getGroupId())) {
            throw new ServiceException(ServiceExceptionErrorCode.GROUP_NAME_ERROR, "小组名已存在!");
        }
        group_.setCourse(course);
        group_.setLeader(leader);
        List<Homework> homeworkList = course.getHomework();
        if (homeworkList != null && homeworkList.size() > 0) {
            for (Homework h:homeworkList) {
                HomeworkGroup hg = new HomeworkGroup(h, group_);
                group_.getHomeworkGroups().add(hg);
            }
        }
        if (members != null && members.size() > 0) {
            for (Student s:members) {
                GroupStudent gs = new GroupStudent(group_, s);
                group_.getGroupStudentList().add(gs);
            }
        }
        this.merge(group_);
    }
}
