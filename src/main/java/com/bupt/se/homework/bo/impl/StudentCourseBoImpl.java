package com.bupt.se.homework.bo.impl;

import com.bupt.se.homework.bo.StudentCourseBo;
import com.bupt.se.homework.dao.BasicDao;
import com.bupt.se.homework.dao.CourseDAO;
import com.bupt.se.homework.dao.StudentCourseDAO;
import com.bupt.se.homework.dao.StudentDAO;
import com.bupt.se.homework.entity.StudentCourse;
import com.bupt.se.homework.entity.StudentCoursePK;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @description:
 * @author: zh
 * @create: 2018-11-16 14:39
 **/
@Service("studentCourseBo")
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
}
