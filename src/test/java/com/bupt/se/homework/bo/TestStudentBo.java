package com.bupt.se.homework.bo;

import com.bupt.se.homework.UnitTestBase;
import com.bupt.se.homework.dao.StudentDAO;
import com.bupt.se.homework.entity.Student;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

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
    public void testAddList() {
        List<Student> list = new ArrayList<>();
        String[] array = new String[50];
        int index = 0;
        for (int i = 2015211200; i < 2015211250; ++i) {
            Student s = new Student(String.valueOf(i), String.valueOf(i), String.valueOf(i));
            list.add(s);
            array[index++] = String.valueOf(i);
        }
        StudentDAO studentDAO = super.getBean("studentDAO");
        Assert.assertTrue(studentDAO.deleteArray(array));
        Assert.assertTrue(studentDAO.save(list));
    }
}
