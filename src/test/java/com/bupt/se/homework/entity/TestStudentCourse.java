package com.bupt.se.homework.entity;

import com.bupt.se.homework.UnitTestBase;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import java.util.Map;
import java.util.Set;


/**
 * @description: test entity StudentCourse
 * @author: zh
 * @create: 2018-11-14 12:21
 **/
public class TestStudentCourse extends UnitTestBase {

    public TestStudentCourse() {
        super("classpath:SpringBeans.xml");
    }

    @Test
    public void test() {
        SessionFactory sessionFactory = super.getBean("sessionFactory");
        Session session = sessionFactory.getCurrentSession();
        Student s = new Student("1111111111", "test1", "11111111");
        Course c = new Course();
        c.setCourseId("100010");
        c.setCourseName("test course");
        StudentCourse studentCourse = new StudentCourse(s, c);
        Transaction transaction = session.beginTransaction();
        session.save(s);
        session.save(c);
        session.save(studentCourse);
        transaction.commit();
    }

    @Test
    public void testModifyScore() {
        SessionFactory sessionFactory = super.getBean("sessionFactory");
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Course c = session.get(Course.class, "100010");
        Set<StudentCourse> studentCourses = c.getStudentCourses();
        for (StudentCourse sc:studentCourses) {
            sc.setGrade(90.);
            session.update(sc);
        }
        transaction.commit();
    }

    @Test
    public void testDelete() {
        SessionFactory sessionFactory = super.getBean("sessionFactory");
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
//        Course c = session.get(Course.class, "100010");
        Student s = session.get(Student.class, "1111111111");
        session.delete(s);
        transaction.commit();
    }
}
