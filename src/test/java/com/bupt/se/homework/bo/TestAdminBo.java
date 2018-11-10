package com.bupt.se.homework.bo;

import com.bupt.se.homework.UnitTestBase;
import com.bupt.se.homework.entity.Admin;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

/**
 * @description: AdminBo test
 * @author: zh
 * @create: 2018-11-10 14:49
 **/
@RunWith(BlockJUnit4ClassRunner.class)
public class TestAdminBo extends UnitTestBase {


    public TestAdminBo() {
        super("classpath:SpringBeans.xml");
    }

    @Test
    public void testLogin() {
        AdminBo adminBo = super.getBean("adminBo");
        System.out.println(adminBo.login("2015211203", "12345678"));
    }


}
