package com.bupt.se.homework.bo.impl;

import com.bupt.se.homework.bo.ReturnCode;
import com.bupt.se.homework.bo.TeacherBo;
import com.bupt.se.homework.dao.BasicDao;
import com.bupt.se.homework.dao.CourseDAO;
import com.bupt.se.homework.dao.HomeworkDAO;
import com.bupt.se.homework.dao.TeacherDAO;
import com.bupt.se.homework.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @Description: Teacher 业务逻辑实现类
 * @Author: zh
 * @Date: 2018/11/10
 **/
@Service("teacherBo")
@Transactional
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
    public boolean addTeacher(Teacher teacher) {
        return teacherDAO.save(teacher);
    }

    @Override
    public boolean updateTeacher(Teacher teacher) {
        return teacherDAO.update(teacher);
    }

    @Override
    public boolean deleteTeacher(String id) {
        return teacherDAO.delete(id);
    }

    @Override
    public List<Teacher> listTeacher() {
        return teacherDAO.findResultList(null, null, null, null, null, null, 0, 0);
    }

    @Override
    public Set<Course> getCourseSet(Teacher teacher) {
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
    public Map<Student, Integer> getCourseTranscript(String teacherId, String courseId) {
        Map<Student, Integer> map = null;
        LinkedHashMap<Object, Object> equals = new LinkedHashMap<>();
        equals.put("teacherId", teacherId);
        equals.put("courseId", courseId);
        Course c = courseDAO.get(equals, null, null, null, null);
        if (c != null) {
            Set<StudentCourse> studentCourses = c.getStudentCourses();
            if (studentCourses != null && studentCourses.size() > 0) {
                map = new HashMap<>();
                for (StudentCourse sc:studentCourses) {
                    map.put(sc.getStudent(), sc.getGrade());
                }
            }
        }
        return map;
    }

    @Override
    public int AssignHomework(Course course, Homework homework) {
        return teacherDAO.AssignHomework(course, homework);
    }
}
