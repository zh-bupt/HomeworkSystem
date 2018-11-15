package com.bupt.se.homework.bo;

import com.bupt.se.homework.UnitTestBase;
import com.bupt.se.homework.bo.impl.CourseBoImpl;
import com.bupt.se.homework.bo.impl.StudentBoImpl;
import com.bupt.se.homework.entity.Course;
import com.bupt.se.homework.entity.Student;
import com.bupt.se.homework.entity.StudentCourse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import java.nio.charset.CoderResult;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @description: test course bo
 * @author: zh
 * @create: 2018-11-15 16:58
 **/
public class TestCourseBo extends UnitTestBase {
    public TestCourseBo() {
        super("classpath:SpringBeans.xml");
    }

    @Test
    public void addData() {
        CourseBo courseBo = super.getBean("courseBo");
        List<Course> courseList = new ArrayList<>();
        for (int i = 0; i < 10; ++i) {
            Course c = new Course();
            c.setCourseId("C" + String.valueOf(i));
            c.setCourseName("test course " + String.valueOf(i));
            c.setCreateTime(new Date());
            courseList.add(c);
        }
        courseBo.save(courseList);

        StudentBo studentBo = super.getBean("studentBo");
        List<Student> studentList = new ArrayList<>();
        for (int i = 0; i < 30; ++i) {
            String temp = "20172112" + (i < 10 ? ("0" + String.valueOf(i)):String.valueOf(i));
            Student s = new Student();
            s.setStudentId(temp);
            s.setStudentName("student" + String.valueOf(i));
            s.setPassword(temp);
            studentList.add(s);
        }
        studentBo.save(studentList);

        for (int i = 0; i < 30; ++i) {
            Student s = studentList.get(i);
            for (int j = 0; j < 3; ++j) {
                Random random = new Random();
                Course c = courseList.get(random.nextInt(10));
                s.getStudentCourses().add(new StudentCourse(s, c));
            }
            studentBo.update(s);
        }
    }
}
