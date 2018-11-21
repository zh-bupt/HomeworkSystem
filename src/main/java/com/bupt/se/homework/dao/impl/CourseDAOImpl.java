package com.bupt.se.homework.dao.impl;

import com.bupt.se.homework.dao.CourseDAO;
import com.bupt.se.homework.entity.Course;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("courseDAO")
@Transactional
public class CourseDAOImpl extends BasicDAOImpl<Course, String> implements CourseDAO {
}
