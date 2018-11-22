package com.bupt.se.homework.bo;

import com.bupt.se.homework.UnitTestBase;
import com.bupt.se.homework.entity.Course;
import com.bupt.se.homework.entity.Homework;
import com.bupt.se.homework.entity.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * @description: teacher bo test
 * @author: zh
 * @create: 2018-11-10 19:07
 **/
public class TestTeacherBo extends UnitTestBase {

    public TestTeacherBo() {
        super("classpath:SpringBeans.xml");
    }

    @Test
    public void testCRUD() {
        TeacherBo teacherBo = this.getBean("teacherBo");
        Teacher t1 = new Teacher();
        t1.setTeacherId("1990211111");
        t1.setTeacherName("t1");
        t1.setPassword("11111111");
        teacherBo.addTeacher(t1);
        System.out.println(teacherBo.login("1990211111", "11111111"));
        Teacher t2 = new Teacher();
        t2.setTeacherId("1990211112");
        t2.setPassword("11111111");
        t2.setTeacherName("t2");
        teacherBo.addTeacher(t2);
        List<Teacher> list = teacherBo.listTeacher();
        if (list != null && list.size() > 0) {
            for (Teacher t:list) {
                System.out.println(t.getTeacherId() + ":" + t.getTeacherName());
            }
        }
        t1.setTeacherName("tt1");
        teacherBo.updateTeacher(t1);
        list = teacherBo.listTeacher();
        if (list != null && list.size() > 0) {
            for (Teacher t:list) {
                System.out.println(t.getTeacherId() + ":" + t.getTeacherName());
            }
        }
    }

    @Test
    public void testAddHomework() {
        TeacherBo teacherBo = super.getBean("teacherBo");
        Teacher teacher = teacherBo.get("2011222222");
        List<Course> courses = new ArrayList<>();
        courses.addAll(teacher.getCourses());
        Course course = courses.get(0);
        if (course != null) {
            System.out.println(course.getCourseName());
            Homework homework = new Homework();
            homework.setDeadline(new Date());
            homework.setContent("test homework content");
            System.out.println(teacherBo.AssignHomework(course, homework));
        }

    }
}
