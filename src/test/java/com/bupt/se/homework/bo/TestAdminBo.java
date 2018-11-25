package com.bupt.se.homework.bo;

import com.bupt.se.homework.UnitTestBase;
import com.bupt.se.homework.entity.Admin;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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
        Log log = LogFactory.getLog(this.getClass());
        log.info("test");
        AdminBo adminBo = super.getBean("adminBo");
//        System.out.println(adminBo.delete("2015211203"));
        System.out.println(adminBo.save(new Admin("2015211203", "zh", "12345678")));
        System.out.println(adminBo.login("2015211203", "12345678"));
        System.out.println(adminBo.update(new Admin("2015211203", "zh", "11111111")));
        System.out.println(adminBo.login("2015211203", "12345678"));
        System.out.println(adminBo.login("2015211203", "11111111"));
//        System.out.println(adminBo.delete("2015211203"));
//        System.out.println(adminBo.update(new Admin("2015211203", "zh", "11111111")));
    }


}
