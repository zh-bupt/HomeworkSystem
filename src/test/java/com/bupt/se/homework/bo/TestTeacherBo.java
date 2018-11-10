package com.bupt.se.homework.bo;

import com.bupt.se.homework.UnitTestBase;
import com.bupt.se.homework.entity.Teacher;
import org.junit.Test;

import java.util.List;

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
}
