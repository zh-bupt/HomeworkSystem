package com.bupt.se.homework.dao.impl;

import com.bupt.se.homework.dao.HomeworkDAO;
import com.bupt.se.homework.entity.Homework;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;

/**
 * @ClassName: HomeworkDAOImpl
 * @Description: TODO
 * @Author: kwong
 * @Create: 2018/11/11 20:27
 **/
@Repository("homeworkDAO")
public class HomeworkDAOImpl extends BasicDAOImpl<Homework, Integer> implements HomeworkDAO{

}
