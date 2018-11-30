package com.bupt.se.homework.bo.impl;

import com.bupt.se.homework.bo.ReturnCode;
import com.bupt.se.homework.bo.TeacherBo;
import com.bupt.se.homework.dao.BasicDao;
import com.bupt.se.homework.dao.CourseDAO;
import com.bupt.se.homework.dao.HomeworkDAO;
import com.bupt.se.homework.dao.TeacherDAO;
import com.bupt.se.homework.entity.*;
import com.bupt.se.homework.exception.ServiceException;
import com.bupt.se.homework.exception.ServiceExceptionErrorCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @Description: Teacher 业务逻辑实现类
 * @Author: zh
 * @Date: 2018/11/10
 **/
@Service("teacherBo")
public class TeacherBoImpl extends BasicBoImpl<Teacher, String> implements TeacherBo {

    TeacherDAO teacherDAO;
    CourseDAO courseDAO;
    HomeworkDAO homeworkDAO;

    @Autowired
    @Qualifier("teacherDAO")
    public void setTeacherDAO(BasicDao<Teacher, String> basicDao){
        super.setBasicDao(basicDao);
        this.teacherDAO = (TeacherDAO) basicDao;
    }

    @Autowired
    public void setCourseDAO(CourseDAO courseDAO) {
        this.courseDAO = courseDAO;
    }

    @Autowired
    public void setHomeworkDAO(HomeworkDAO homeworkDAO) {
        this.homeworkDAO = homeworkDAO;
    }

    @Override
    public void addTeacher(Teacher teacher) throws Exception {
        if (this.exists(teacher.getTeacherId())) {
            throw new ServiceException(ServiceExceptionErrorCode.TEACHER_DUPLICATED,
                    "教师 " + teacher.getTeacherId() + " 已存在");
        }
        this.save(teacher);
        logger.info("Add a teacher " + teacher.getTeacherId());
    }

    @Override
    public void updateTeacher(Teacher teacher) throws Exception {
        if (!this.exists(teacher.getTeacherId())) {
            throw new ServiceException(ServiceExceptionErrorCode.TEACHER_NOT_FOUND,
                    "教师 " + teacher.getTeacherId() + " 不存在");
        }
        this.update(teacher);
        logger.info("Update teacher " + teacher.getTeacherId());
    }

    @Override
    public void deleteTeacher(String id) throws Exception {
        this.delete(id);
        logger.info("Delete teacher " + id);
    }

    @Override
    public List<Teacher> listTeacher() {
        return teacherDAO.findResultList(null, null, null, null, null, null, 0, 0);
    }

    @Override
    public List<Course> getCourseSet(Teacher teacher) {
        return teacher.getCourses();
    }

    @Override
    public String login(String id, String password) {
        Teacher teacher = teacherDAO.get(id);
        if (teacher == null) return ReturnCode.USER_NOT_FOUNT;
        if (!teacher.getPassword().equals(password)) return ReturnCode.WRONG_PASSWORD;
        return ReturnCode.LOGIN_SUCCESS;
    }

    /**
     * @Description: 老师获得成绩单, 包括每个学生的成绩
     * @param courseId
     * @return: java.util.Map<com.bupt.se.homework.entity.Student , java.lang.Integer>
     * @Author: zh
     * @Date: 2018/11/16
     **/
    @Override
    public Map<Student, Double> getCourseTranscript(String teacherId, String courseId) {
        if (!this.exists(teacherId)) {
            throw new ServiceException(ServiceExceptionErrorCode.TEACHER_NOT_FOUND,
                    "教师 " + teacherId + " 不存在");
        }
        if (!courseDAO.exists(courseId)) {
            throw new ServiceException(ServiceExceptionErrorCode.COURSE_NOT_FOUND,
                    "课程 " + courseId + " 不存在");
        }
        Map<Student, Double> map = null;
        LinkedHashMap<Object, Object> equals = new LinkedHashMap<>();
        equals.put("teacher.teacherId", teacherId);
        equals.put("courseId", courseId);
        Course c = courseDAO.get(equals, null, null, null, null);
        if (c != null) {
            List<StudentCourse> studentCourses = c.getStudentCourses();
            if (studentCourses != null && studentCourses.size() > 0) {
                map = new HashMap<>();
                for (StudentCourse sc:studentCourses) {
                    map.put(sc.getStudent(), sc.getGrade());
                }
            }
        }
        return map;
    }

    /**
     * @Description: 老师发布作业
     * @param courseId
     * @param homework
     * @return: void
     * @Author: zh
     * @Date: 2018/11/27
     **/
    @Override
    public void assignHomework(String courseId, Homework homework) throws Exception {
        Course course = courseDAO.get(courseId);
        if (course == null) {
            throw new ServiceException(ServiceExceptionErrorCode.COURSE_NOT_FOUND,
                    "课程 " + courseId + " 不存在");
        }
        course.getHomework().add(homework);
        homework.setCourse(course);
        if (CalculateHomePercentage(course) > 100) {
            throw new ServiceException(ServiceExceptionErrorCode.HOMEWORK_PERCENTAGE_ERROR,
                    "作业比例超过100%. 请重新设置作业比例.");
        }
        try{
            teacherDAO.assignHomework(course, homework);
            logger.info("Assigned homework for course " + courseId);
        } catch (Exception e) {
            throw new ServiceException(ServiceExceptionErrorCode.ASSIGN_HOMEWORK_ERROR, e.getMessage());
        }
    }

    private int CalculateHomePercentage(Course course) {
        List<Homework> homeworkSet = course.getHomework();
        int total = 0;
        for (Homework homework:homeworkSet) {
            total += homework.getPercentage();
            System.out.println("total: " + total);
        }
        return total;
    }
}
