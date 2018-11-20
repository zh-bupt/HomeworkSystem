package com.bupt.se.homework.db;

import com.bupt.se.homework.UnitTestBase;
import com.bupt.se.homework.entity.Course;
import com.bupt.se.homework.entity.Group_;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @description: 导出数据库模式
 * @author: zh
 * @create: 2018-11-10 12:59
 **/
public class ExportSchemaTest extends UnitTestBase {

    public ExportSchemaTest() {
        super("classpath:SpringBeans.xml");
    }

    /**
     * @Description: 导出数据库schema
     * @param
     * @return: void
     * @Author: zh
     * @Date: 2018/11/10
     **/
    @Test
    public void exportSchema() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("SpringBeans.xml");
        context.start();
        SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");
    }

    @Test
    public void add() {
//        SessionFactory sessionFactory = super.getBean("sessionFactory");
//        Session session = sessionFactory.getCurrentSession();
//        Transaction transaction = session.beginTransaction();
//        Course course = new Course();
//        course.setCourseId(1);
//        course.setCourseName("test");
//        Teacher teacher = new Teacher();
//        teacher.setTeacherId("1234567890");
//        teacher.setTeacherName("haha");
//        teacher.setPassword("11111111");
//        teacher.getCourses().add(course);
//        course.setTeacher(teacher);
//        session.save(teacher);
//        transaction.commit();

        SessionFactory sessionFactory = super.getBean("sessionFactory");
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Course course = new Course();
        course.setCourseId("123");
        course.setCourseName("test");
        Group_ group1 = new Group_();
        group1.setName("test group1");
//        session.save(group1);
        Group_ group2 = new Group_();
        group2.setName("test group2");
//        session.save(group2);
        course.getGroups().add(group1);
        course.getGroups().add(group2);
        session.save(course);
        transaction.commit();
    }

    @Test
    public void delete() {
//        SessionFactory sessionFactory = super.getBean("sessionFactory");
//        Session session = sessionFactory.getCurrentSession();
//        Transaction transaction = session.beginTransaction();
//        Teacher teacher = session.get(Teacher.class, "1234567890");
//        System.out.println(teacher.getTeacherName());
//        session.delete(teacher);
//        transaction.commit();

        SessionFactory sessionFactory = super.getBean("sessionFactory");
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Course course = session.get(Course.class, 123);
        System.out.println(course.getCourseName());
        session.delete(course);
        transaction.commit();
    }
}
