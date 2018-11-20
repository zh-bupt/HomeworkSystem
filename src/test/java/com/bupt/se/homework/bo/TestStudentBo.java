package com.bupt.se.homework.bo;

import com.bupt.se.homework.UnitTestBase;
import com.bupt.se.homework.dao.StudentDAO;
import com.bupt.se.homework.entity.*;
import org.junit.Assert;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @description: studentBo的测试类
 * @author: zh
 * @create: 2018-11-10 15:35
 **/
public class TestStudentBo extends UnitTestBase {
    public TestStudentBo() {
        super("classpath:SpringBeans.xml");
    }

    @Test
    public void testLogin() {
        StudentBo studentBo = super.getBean("studentBo");
//        Assert.assertTrue(studentBo.deleteStudent("2015211205"));
//        Assert.assertTrue(studentBo.addStudent(new Student("2015211205", "xxx", "11111111")));
        System.out.println(studentBo.login("2015211203", "2015211203"));
        System.out.println(studentBo.updateStudent(new Student("2015211204", "krf", "12345678")));
        System.out.println(studentBo.login("2015211204", "12345678"));

        System.out.println(studentBo.login("2015211119", "11111111"));

//        StudentDAO studentDAO = super.getBean("studentDAO");
//        LinkedHashMap<Object, Object> equals = new LinkedHashMap<>();
//        equals.put("classId", "2015211303");
//        List<Student> list = studentDAO.findResultList(equals, null, null, null, null, null, 0, 0);
//        if (list != null && list.size() > 0) {
//            for (Student s:list) {
//                System.out.println(s.getStudentName());
//            }
//        }
    }

    @Test
    public void testAddList() throws ParseException {
        List<Student> list = new ArrayList<>();
        String[] array = new String[50];
        int index = 0;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = format.parse("2015-09-01");
        for (int i = 2015211200; i < 2015211250; ++i) {
            Student s = new Student(String.valueOf(i), String.valueOf(i), String.valueOf(i));
            s.setEntranceDate(date);
            list.add(s);
            array[index++] = String.valueOf(i);
        }
        StudentBo studentBo = super.getBean("studentBo");
        Assert.assertTrue(studentBo.deleteArray(array));
        Assert.assertTrue(studentBo.save(list));
    }

    @Test
    public void testGetHomeworkGroup() {
        StudentBo studentBo = super.getBean("studentBo");
        Student student = studentBo.get("2015211203");
        HomeworkBo homeworkBo = super.getBean("homeworkBo");
        Homework homework = homeworkBo.get(1);
        HomeworkGroup homeworkGroup = studentBo.getHomeworkGroup(student, homework);
        System.out.println(homeworkGroup.getComment());
    }
}
