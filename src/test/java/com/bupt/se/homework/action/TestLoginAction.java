package com.bupt.se.homework.action;

import com.bupt.se.homework.UnitTestBase;
import com.bupt.se.homework.bo.AdminBo;
import com.bupt.se.homework.bo.StudentBo;
import org.junit.Test;

public class TestLoginAction extends UnitTestBase {
    public TestLoginAction() {
        super("classpath:SpringBeans.xml");
    }

    @Test
    public void testLogin() {

        LoginAction loginAction = new LoginAction();
        loginAction.setStudentBo((StudentBo)super.getBean("studentBo"));
        //System.out.println(loginAction.login(2,"2015211203", "12345678"));

        loginAction.setAdminBo((AdminBo)super.getBean("adminBo"));
        //System.out.println(loginAction.login(0,"2015211203", "12345678"));
    }
}
