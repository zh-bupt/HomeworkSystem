package com.bupt.se.homework.db;

import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.internal.SessionFactoryImpl;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.hibernate.tool.schema.TargetType;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import java.util.EnumSet;

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
        SessionFactoryImpl sessionFactory = (SessionFactoryImpl) context.getBean("sessionFactory");
    }
}
