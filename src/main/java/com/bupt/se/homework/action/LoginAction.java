package com.bupt.se.homework.action;


import com.bupt.se.homework.bo.AdminBo;
import com.bupt.se.homework.bo.StudentBo;
import com.bupt.se.homework.bo.TeacherBo;
import com.opensymphony.xwork2.ActionContext;

/**
 * @ClassName: LoginAction
 * @Description: 负责登录
 * @Author: KRF
 * @Create: 2018/11/09
 **/

public class LoginAction {

    StudentBo studentBo;
    TeacherBo teacherBo;
    AdminBo adminBo;

    public void setStudentBo(StudentBo studentBo) {
        this.studentBo = studentBo;
    }

    public void setTeacherBo(TeacherBo teacherBo) {
        this.teacherBo = teacherBo;
    }

    public void setAdminBo(AdminBo adminBo) {
        this.adminBo = adminBo;
    }

    public String login(int role, String id, String password){
        String response;
        switch (role){
            case 0://管理员
                response = adminBo.login(id,password);
                break;
            case 1://教师
                response = teacherBo.login(id,password);
                break;
            case 2://学生
                response = studentBo.login(id,password);
                break;
            default:
                response = "Role Error";


        }
        //ActionContext.getContext().getSession().clear();

        return response;//TODO 根据不同的返回来提醒用户
    }
}
