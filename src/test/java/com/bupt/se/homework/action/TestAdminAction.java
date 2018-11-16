package com.bupt.se.homework.action;

import com.bupt.se.homework.UnitTestBase;
import com.bupt.se.homework.bo.AdminBo;
import com.bupt.se.homework.bo.StudentBo;
import com.bupt.se.homework.bo.TeacherBo;
import org.junit.Test;

/**
 * @ClassName: TestAdminAction
 * @Description: 测试ListTeacherAction
 * @Author: kwong
 * @Create: 2018/11/15 13:45
 **/

public class TestAdminAction extends UnitTestBase {
    public TestAdminAction() {
        super("classpath:SpringBeans.xml");
    }

    @Test
    public void testListTeacher() {
    //成功了！

        AdminAction adminAction = new AdminAction();
        adminAction.setTeacherBo((TeacherBo)super.getBean("teacherBo"));
        try {
            if(adminAction.listTeacher()=="success")
                System.out.println("Success");
            else
                System.out.println("Failed");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
