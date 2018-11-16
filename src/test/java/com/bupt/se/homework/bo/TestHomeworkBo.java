package com.bupt.se.homework.bo;

import com.bupt.se.homework.UnitTestBase;
import com.bupt.se.homework.entity.Course;
import com.bupt.se.homework.entity.Homework;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @description: HomeworkBo test
 * @author: zh
 * @create: 2018-11-16 11:29
 **/
public class TestHomeworkBo extends UnitTestBase {

    public TestHomeworkBo() {
        super("classpath:SpringBeans.xml");
    }

    @Test
    public void testAdd() {
        CourseBo courseBo = super.getBean("courseBo");
        HomeworkBo homeworkBo = super.getBean("homeworkBo");
        List<Course> courses = courseBo.listCourse();
        List<Homework> homework = new ArrayList<>();
        for (Course c:courses) {
            Homework h = new Homework();
            h.setContent("homework content for course " + c.getCourseName());
            h.setCourse(c);
            h.setDeadline(new Date());
            homework.add(h);
            homeworkBo.save(h);
        }
//        homeworkBo.save(homework);
    }
}

