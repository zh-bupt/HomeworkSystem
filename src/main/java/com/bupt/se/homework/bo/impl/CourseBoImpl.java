package com.bupt.se.homework.bo.impl;

import com.bupt.se.homework.bo.CourseBo;
import com.bupt.se.homework.bo.GroupBo;
import com.bupt.se.homework.dao.BasicDao;
import com.bupt.se.homework.dao.CourseDAO;
import com.bupt.se.homework.dao.StudentCourseDAO;
import com.bupt.se.homework.entity.*;
import com.bupt.se.homework.exception.ServiceException;
import com.bupt.se.homework.exception.ServiceExceptionErrorCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @description: CourseBo 实现类
 * @author: zh
 * @create: 2018-11-15 16:38
 **/
@Service("courseBo")
@Transactional
public class CourseBoImpl extends BasicBoImpl<Course, String> implements CourseBo {

    private CourseDAO courseDAO;
    private GroupBo groupBo;
    private StudentCourseDAO studentCourseDAO;

    @Autowired
    @Qualifier("courseDAO")
    public void setCourseDAO(BasicDao<Course, String> basicDao) {
        super.setBasicDao(basicDao);
        this.courseDAO = (CourseDAO) basicDao;
    }

    @Autowired
    public void setGroupBo(GroupBo groupBo) {
        this.groupBo = groupBo;
    }

    @Autowired
    public void setStudentCourseDAO(StudentCourseDAO studentCourseDAO) {
        this.studentCourseDAO = studentCourseDAO;
    }

//    @Override
//    public Set<StudentCourse> getStudentCourse(Course course) {
//        return course.getStudentCourses();
//    }

    @Override
    @Transactional(readOnly = true)
    public List<Student> getStudentList(String courseId) throws Exception {
        Course course = this.get(courseId);
        if (course == null) {
            throw new ServiceException(ServiceExceptionErrorCode.COURSE_NOT_FOUND,
                    "课程 " + courseId + " 不存在.");
        }
        List<StudentCourse> studentCourses = course.getStudentCourses();
        List<Student> list = null;
        if (studentCourses != null && studentCourses.size() > 0) {
            list = new ArrayList<>();
            for (StudentCourse sc:studentCourses) {
                list.add(sc.getStudent());
            }
        }
        return list;
    }

    /**
     * @Description: 课程成绩统计
     * @param course
     * @return: java.util.Map<java.lang.String,java.lang.Object>
     * @Author: zh
     * @Date: 2018/11/15
     **/
    @Override
    public Map<String, Object> getStatistics(Course course) {
        Map<String, Object> map = new HashMap<>();
        int countPerTenScore[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int totalCount = 0;
        List<StudentCourse> studentCourses = course.getStudentCourses();
        if (studentCourses != null && studentCourses.size() > 0) {
            for (StudentCourse sc:studentCourses) {
                countPerTenScore[(int) Math.floor(sc.getGrade() / 10)]++;
                totalCount++;
            }
        }
        map.put("count per 10 score", countPerTenScore);
        map.put("totalCount", totalCount);
        return map;
    }

    @Override
    @Transactional(noRollbackFor = {ServiceException.class})
    public void addCourse(Course course) {
        if (exists(course.getCourseId())) {
            throw new ServiceException(ServiceExceptionErrorCode.COURSE_DUPLICATED,
                    "课程 " + course.getCourseId() + " 已存在.");
        }
        this.save(course);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Course> listCourse() {
        return this.getList(null, null, null, null, null, null, 0, 0);
    }

    @Override
    @Transactional(readOnly = true, noRollbackFor = {ServiceException.class})
    public List<Homework> listHomework(String courseId) {
        Course course = courseDAO.get(courseId);
        if (course == null) {
            throw new ServiceException(ServiceExceptionErrorCode.COURSE_NOT_FOUND,
                    "课程 " + courseId + " 不存在.");
        }
        List<Homework> list = null;
        if (course != null) {
            List<Homework> homeworkSet = course.getHomework();
            if (homeworkSet != null && homeworkSet.size() > 0) {
                list = new ArrayList<>();
                for (Homework h:homeworkSet) {
                    list.add(h);
                }
            }
        }
        return list;
    }

    /**
     * @Description: 计算对应课程每个学生的成绩
     * @param courseId
     * @return: void
     * @Author: zh
     * @Date: 2018/11/25
     **/
    @Override
    @Transactional(noRollbackFor = {ServiceException.class})
    public void calculateScore(String courseId) throws Exception {
        logger.info("Calculate score for course " + courseId);
        Course course = this.get(courseId);
        if (course == null) {
            throw new ServiceException(ServiceExceptionErrorCode.COURSE_NOT_FOUND,
                    "课程 " + courseId + " 不存在.");
        }
        List<Group_> groups = course.getGroups();
        if (groups != null && groups.size() > 0) {
            for (Group_ g:groups) {
                // 先计算小组成绩
                groupBo.calculateScore(g);
                // 再计算课程成绩
                List<GroupStudent> groupStudents = g.getGroupStudentList();
                if (groupStudents != null && groupStudents.size() > 0) {
                    for (GroupStudent gs:groupStudents) {
                        double courseScore = (gs.getContribution() / 100.) * gs.getGroup_().getGroupScore();
                        StudentCourse sc = new StudentCourse(gs.getStudent(), course);
                        sc.setGrade(courseScore);
                        studentCourseDAO.update(sc);
                    }
                }
            }
        }
    }
}
