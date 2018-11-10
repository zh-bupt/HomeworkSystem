package com.bupt.se.homework.bo;

import com.bupt.se.homework.UnitTestBase;
import org.junit.Test;

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
//        System.out.println(studentBo.login("2015211203", "2015211203"));

//        System.out.println(studentBo.login("2015211203", "12345678"));

        System.out.println(studentBo.login("2015211204", "2015211203"));


    }
}
