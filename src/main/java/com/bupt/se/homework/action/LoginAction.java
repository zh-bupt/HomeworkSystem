package com.bupt.se.homework.action;


import com.bupt.se.homework.bo.AdminBo;
import com.bupt.se.homework.bo.ReturnCode;
import com.bupt.se.homework.bo.StudentBo;
import com.bupt.se.homework.bo.TeacherBo;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @ClassName: LoginAction
 * @Description: 负责登录
 * @Author: KRF
 * @Create: 2018/11/09
 **/

public class LoginAction extends ActionSupport {

    StudentBo studentBo;
    TeacherBo teacherBo;
    AdminBo adminBo;

    private String role;
    private String id;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String password;

    public void setStudentBo(StudentBo studentBo) {
        this.studentBo = studentBo;
    }

    public void setTeacherBo(TeacherBo teacherBo) {
        this.teacherBo = teacherBo;
    }

    public void setAdminBo(AdminBo adminBo) {
        this.adminBo = adminBo;
    }


    public String login() throws Exception {
        super.clearErrorsAndMessages();
        if("".equals(id)) {
            super.addActionError("用户名不能为空！");
            return "login";
        }
        if("".equals(password)) {
            super.addActionError("密码不能为空！");
            return "login";
        }

        System.out.println(id+","+password);
        String response;
        System.out.println(role);
        ActionContext.getContext().getSession().clear();
        Map<String, Object> session = ActionContext.getContext().getSession();

        switch (role){
            case "管理员"://管理员
                response = adminBo.login(id,password);
                if(verify(response).equals("success"))
                {
                    System.out.println(session.get("role").toString()+session.get("id").toString());
                    return "admin";
                }
                else
                    return "login";//有错误，继续在登录界面

            case "教师"://教师
                response = teacherBo.login(id,password);
                if(verify(response).equals("success"))
                {
                    System.out.println(session.get("role").toString()+session.get("id").toString());
                    return "teacher";
                }
                else
                    return "login";//有错误，继续在登录界面
            case "学生"://学生
                response = studentBo.login(id,password);
                String returnString = verify(response);
                if(returnString.equals("success"))
                {
                    System.out.println(session.get("role").toString()+session.get("id").toString());
                    return "student";
                }
                else if(returnString.equals("error"))
                    return "login";//有错误，继续在登录界面
                else
                {
                    System.out.println(session.get("role").toString()+session.get("id").toString());
                    return "changePW";//强制修改密码
                }
            default:
                super.addActionError("请选择登录用户类型！");
                return "login";
        }

    }

    /**
     * @Author KRF
     * @Description 用来判断response的
     * @Date 15:40 2018/11/18
     * @Param [response]
     * @return java.lang.String
     **/

    public String verify(String response){
        System.out.println(response);
        HttpServletRequest request = ServletActionContext.getRequest();
        ActionContext actionContext = ActionContext.getContext();
        Map<String, Object> session = actionContext.getSession();
        switch (response) {
            case ReturnCode.LOGIN_SUCCESS:
//                    ServletActionContext.getRequest().getSession().setAttribute("role",role);
//                    ServletActionContext.getRequest().getSession().setAttribute("id",id);

                session.put("role", role);
                session.put("id", id);
                return "success";
            case ReturnCode.FIRST_LOGIN:
//                    ServletActionContext.getRequest().getSession().setAttribute("role",role);
//                    ServletActionContext.getRequest().getSession().setAttribute("id",id);
                session.put("role", role);
                session.put("id", id);
                if(role.equals("学生"))//学生
                    return "change password";

                return "success";
            case ReturnCode.USER_NOT_FOUNT:
                super.addActionError("用户不存在，请重新输入");
                return "error";
            case ReturnCode.WRONG_PASSWORD:
                super.addActionError("密码错误，请重新输入");
                return "error";
            default:
                super.addActionError("其他错误");
                return "input";
        }

    }


}
