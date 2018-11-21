package com.bupt.se.homework.bo.impl;

import com.bupt.se.homework.bo.StudentCourseBo;
import com.bupt.se.homework.dao.BasicDao;
import com.bupt.se.homework.dao.CourseDAO;
import com.bupt.se.homework.dao.StudentCourseDAO;
import com.bupt.se.homework.dao.StudentDAO;
import com.bupt.se.homework.entity.Course;
import com.bupt.se.homework.entity.Student;
import com.bupt.se.homework.entity.StudentCourse;
import com.bupt.se.homework.entity.StudentCoursePK;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * @description:
 * @author: zh
 * @create: 2018-11-16 14:39
 **/
@Service
@Transactional
public class StudentCourseBoImpl
        extends BasicBoImpl<StudentCourse, StudentCoursePK>
        implements StudentCourseBo {
    private StudentCourseDAO studentCourseDAO;
    private StudentDAO studentDAO;
    private CourseDAO courseDAO;

    @Autowired
    @Qualifier("studentCourseDAO")
    public void setStudentCourseDAO(BasicDao<StudentCourse, StudentCoursePK> basicDao) {
        super.setBasicDao(basicDao);
        this.studentCourseDAO = (StudentCourseDAO) basicDao;
    }

    @Autowired
    public void setStudentDAO(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @Autowired
    public void setCourseDAO(CourseDAO courseDAO) {
        this.courseDAO = courseDAO;
    }

//    /**
//     * @Description: 学生获得成绩单, 包括每门课的成绩
//     * @param studentId
//     * @return: java.util.Map<java.lang.String,java.lang.Integer>
//     * @Author: zh
//     * @Date: 2018/11/16
//     **/
//    @Override
//    public Map<String, Integer> getStudentTranscript(String studentId) {
//        Map<String, Integer> map = null;
//        Student s = studentDAO.load(studentId);
//        if (s != null) {
//            Set<StudentCourse> studentCourses = s.getStudentCourses();
//            if (studentCourses != null && studentCourses.size() > 0) {
//                map = new HashMap<>();
//                for (StudentCourse sc:studentCourses) {
//                    map.put(sc.getCourse().getCourseName(), sc.getGrade());
//                }
//            }
//        }
//        return map;
//    }

//    /**
//     * @Description: 老师获得成绩单, 包括每个学生的成绩
//     * @param courseId
//     * @return: java.util.Map<com.bupt.se.homework.entity.Student , java.lang.Integer>
//     * @Author: zh
//     * @Date: 2018/11/16
//     **/
//    @Override
//    public Map<Student, Integer> getTeacherTranscript(String teacherId, String courseId) {
//        Map<Student, Integer> map = null;
//        LinkedHashMap<Object, Object> equals = new LinkedHashMap<>();
//        equals.put("teacherId", teacherId);
//        equals.put("courseId", courseId);
//        Course c = courseDAO.get(equals, null, null, null, null);
//        if (c != null) {
//            Set<StudentCourse> studentCourses = c.getStudentCourses();
//            if (studentCourses != null && studentCourses.size() > 0) {
//                map = new HashMap<>();
//                for (StudentCourse sc:studentCourses) {
//                    map.put(sc.getStudent(), sc.getGrade());
//                }
//            }
//        }
//        return map;
//    }
}
