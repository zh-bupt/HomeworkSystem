package com.bupt.se.homework.bo.impl;

import com.bupt.se.homework.bo.ReturnCode;
import com.bupt.se.homework.bo.StudentBo;
import com.bupt.se.homework.dao.BasicDao;
import com.bupt.se.homework.dao.StudentDAO;
import com.bupt.se.homework.entity.*;
import com.bupt.se.homework.exception.ServiceException;
import com.bupt.se.homework.exception.ServiceExceptionErrorCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.*;

@Service("studentBo")
public class StudentBoImpl extends BasicBoImpl<Student, String> implements StudentBo {

    private StudentDAO studentDAO;

    @Autowired
    @Qualifier("studentDAO")
    public void setStudentDAO(BasicDao<Student, String> basicDao) {
        super.setBasicDao(basicDao);
        this.studentDAO = (StudentDAO) basicDao;
    }

    @Override
    public boolean addStudent(Student student) {
        return this.save(student);
    }

    @Override
    public boolean deleteStudent(String id) {
        return this.delete(id);
    }

    @Override
    public boolean updateStudent(Student student) {
        return this.update(student);
    }

    @Override
    public List<Student> getStudentsByClass(String classId) {
        LinkedHashMap<Object, Object> equals = new LinkedHashMap<>();
        equals.put("classId", classId);
        return studentDAO.findResultList(equals, null, null, null, null, null, 0, 0);
    }

    @Override
    public List<Student> getStudentsByName(String name) {
        LinkedHashMap<Object, Object> equals = new LinkedHashMap<>();
        equals.put("studentName", name);
        return studentDAO.findResultList(equals, null, null, null, null, null, 0, 0);
    }

    @Override
    public List<StudentCourse> getStudentCourse(Student student) {
        return student.getStudentCourses();
    }

    @Override
    public List<Course> getCourseList(Student student) {
        List<Course> list = null;
        List<StudentCourse> studentCourses = this.getStudentCourse(student);
        if (studentCourses != null && studentCourses.size() > 0) {
            list = new ArrayList<>();
            for (StudentCourse sc:studentCourses) {
                list.add(sc.getCourse());
            }
        }
        return list;
    }

    @Override
    public String login(String id, String password) {
        Student student = studentDAO.get(id);
        if (student == null) return ReturnCode.USER_NOT_FOUNT;
        if (!student.getPassword().equals(password)) return ReturnCode.WRONG_PASSWORD;
        if (student.getPassword().equals(student.getStudentId())) return ReturnCode.FIRST_LOGIN;
        return ReturnCode.LOGIN_SUCCESS;
    }

    /**
     * @Description: 学生获得成绩单, 包括每门课的成绩
     * @param studentId
     * @return: java.util.Map<java.lang.String,java.lang.Integer>
     * @Author: zh
     * @Date: 2018/11/16
     **/
    @Override
    public Map<Course, Double> getTranscript(String studentId) {
        Map<Course, Double> map = null;
        Student s = studentDAO.get(studentId);
        if (s == null) {
            logger.info("student: " + studentId + "doesn't exist.");
            throw new ServiceException(ServiceExceptionErrorCode.STUDENT_NOT_FOUND, "学生不存在");
        }
        List<StudentCourse> studentCourses = s.getStudentCourses();
        if (studentCourses != null && studentCourses.size() > 0) {
            map = new HashMap<>();
            for (StudentCourse sc:studentCourses) {
                map.put(sc.getCourse(), sc.getGrade());
            }
        }
        return map;
    }

    @Override
    public List<Homework> getHomeworkList(String studentId, String courseId) {
        return null;
    }

    @Override
    public Group_ getCourseGroup(String studentId, String courseId) {
        logger.info("getCourseGroup(" + studentId + ", " + courseId + ")");
        return studentDAO.getCourseGroup(studentId, courseId);
    }

    @Override
    public List<Group_> getManagedGroups(String studentId) throws Exception {
        Student student = this.get(studentId);
        if (student == null) {
            logger.info("student: " + studentId + "doesn't exist.");
            throw new ServiceException(ServiceExceptionErrorCode.STUDENT_NOT_FOUND, "学生不存在");
        }
        List<Group_> list = null;
        List<Group_> groupSet = student.getGroupsManaged();
        if (groupSet != null && groupSet.size() > 0) {
            list = new ArrayList<>();
            for (Group_ g:groupSet) {
                list.add(g);
            }
        }
        return list;
    }

    @Override
    public HomeworkGroup getHomeworkGroup(Student student, Homework homework) {
        return studentDAO.getHomeworkGroup(student, homework);
    }
}
