package com.bupt.se.homework.action;


import com.bupt.se.homework.bo.AdminBo;
import com.bupt.se.homework.bo.StudentBo;
import com.bupt.se.homework.bo.TeacherBo;
import com.bupt.se.homework.entity.Course;
import com.bupt.se.homework.entity.Homework;
import com.bupt.se.homework.entity.Teacher;
import com.opensymphony.xwork2.ActionContext;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
        testAddHomework();
        String response;
        System.out.println(role);
        switch (role){
            case "管理员"://管理员
                response = adminBo.login(id,password);
                System.out.println(response);
                return "admin";
            case "教师"://教师
                response = teacherBo.login(id,password);
                System.out.println(response);
                return "teacher";
            case "学生"://学生
                response = studentBo.login(id,password);
                System.out.println(response);
                return "student";
            default:
                response = "Role Error";


        }
        //ActionContext.getContext().getSession().clear();

        return response;//TODO 根据不同的返回来提醒用户
    }

    public void testAddHomework() {
        Teacher teacher = teacherBo.get("2011222222");
        List<Course> courses = new ArrayList<>();
        courses.addAll(teacher.getCourses());
        Course course = courses.get(0);
        if (course != null) {
            System.out.println(course.getCourseName());
            Homework homework = new Homework();
            homework.setDeadline(new Date());
            homework.setContent("test homework content");
            System.out.println(teacherBo.AssignHomework(course, homework));
        }

    }

}
