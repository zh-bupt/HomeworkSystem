package com.bupt.se.homework.bo;

import com.bupt.se.homework.UnitTestBase;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;

import java.util.Map;

/**
 * @description:
 * @author: zh
 * @create: 2018-11-16 15:09
 **/
public class TestStudentCourseBo extends UnitTestBase {
    public TestStudentCourseBo() {
        super("SpringBeans.xml");
    }

    @Test
    public void getStudentTranscript() {
        StudentCourseBo bo = super.getBean("studentCourseBo");
        Map<String, Integer> map = bo.getStudentTranscript("2017211200");
        System.out.println("学生 2017211200 的成绩单:");
        if (map != null && map.size() > 0) {
            for (Map.Entry<String, Integer> entry:map.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue().intValue());
            }
        }
    }
}
