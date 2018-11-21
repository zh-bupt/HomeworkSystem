package com.bupt.se.homework.dao.impl;

import com.bupt.se.homework.bo.impl.BasicBoImpl;
import com.bupt.se.homework.dao.StudentCourseDAO;
import com.bupt.se.homework.entity.StudentCourse;
import com.bupt.se.homework.entity.StudentCoursePK;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @description:
 * @author: zh
 * @create: 2018-11-16 14:36
 **/
@Repository("studentCourseDAO")
@Transactional
public class StudentCourseDAOImpl
        extends BasicDAOImpl<StudentCourse, StudentCoursePK>
        implements StudentCourseDAO {
}
