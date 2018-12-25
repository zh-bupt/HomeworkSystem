package com.bupt.se.homework.dao.impl;

import com.bupt.se.homework.dao.StudentHomeworkDAO;
import com.bupt.se.homework.entity.StudentHomework;
import com.bupt.se.homework.entity.StudentHomeworkPK;
import org.springframework.stereotype.Repository;

/**
 * @description:
 * @author: zh
 * @create: 2018-12-25 10:27
 **/
@Repository("studentHomeworkDAO")
public class StudentHomeworkDAOImpl
        extends BasicDAOImpl<StudentHomework, StudentHomeworkPK>
        implements StudentHomeworkDAO {
}
