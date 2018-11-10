package com.bupt.se.homework.db;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @description: 导出数据库模式
 * @author: zh
 * @create: 2018-11-10 12:59
 **/
public class ExportSchemaTest {

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
}
