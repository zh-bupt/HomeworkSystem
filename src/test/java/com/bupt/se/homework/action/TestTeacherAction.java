package com.bupt.se.homework.action;

import com.bupt.se.homework.UnitTestBase;
import com.bupt.se.homework.bo.CourseBo;
import com.bupt.se.homework.bo.impl.CourseBoImpl;
import com.bupt.se.homework.entity.Course;
import com.bupt.se.homework.entity.Homework;
import com.bupt.se.homework.entity.Teacher;
import org.junit.Test;

import java.util.Set;

/**
 * @ClassName: TestTeacherAction
 * @Description: 测试TeacherAction 中的几个模块
 * @Author: kwong
 * @Create: 2018/11/20 20:11
 **/

public class TestTeacherAction  extends UnitTestBase {
    public TestTeacherAction() {
        super("classpath:SpringBeans.xml");
    }

    @Test
    public void testGetHomework() {

        TeacherAction teacherAction = new TeacherAction();
        teacherAction.setCourseBo((CourseBoImpl)super.getBean("courseBo"));
        Course course = teacherAction.getCourseBo().get("cs229");
        Set<Homework> homeworkSet = course.getHomework();
        System.out.println("HomeworkList SIZE"+homeworkSet.size());
    }
}
