package com.bupt.se.homework.action;

import com.bupt.se.homework.bo.AdminBo;
import com.bupt.se.homework.bo.StudentBo;
import com.bupt.se.homework.bo.TeacherBo;
import com.bupt.se.homework.bo.impl.AdminBoImpl;
import com.bupt.se.homework.dao.impl.AdminDAOImpl;
import com.bupt.se.homework.entity.Admin;
import com.bupt.se.homework.entity.Student;
import com.bupt.se.homework.entity.Teacher;
import com.opensymphony.xwork2.ModelDriven;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: AdminAction
 * @Description: 负责处理管理员界面上的操作
 * @Author: KRF
 * @Create: 2018/11/09
 **/


public class AdminAction {
    private AdminBo adminBo;
    private StudentBo studentBo;
    private TeacherBo teacherBo;
    private Student student = new Student();
    private Teacher teacher = new Teacher();
    private Admin admin = new Admin();

    List<Teacher> teacherList = new ArrayList<Teacher>();
    List<Student> studentList = new ArrayList<Student>();

    public void setStudentBo(StudentBo studentBo) {
        this.studentBo = studentBo;
    }

    public void setTeacherBo(TeacherBo teacherBo) {
        this.teacherBo = teacherBo;
    }

    public void setAdminBo(AdminBo adminBo) {
        this.adminBo = adminBo;
    }


    public void addStudent() throws Exception{
        studentBo.addStudent(student);
    }
    public void addTeacher() throws Exception{
        teacherBo.addTeacher(teacher);
    }
//    public void addAdmin() throws Exception{
//        adminBo.addAdmin(admin);
//    }

    public void deleteStudent(String id) throws Exception{
        studentBo.deleteStudent(id);
    }
    public void deleteTeacher(String id) throws Exception{
        teacherBo.deleteTeacher(id);
    }
//    public void deleteAdmin(String id) throws Exception{
//        adminBo.deleteAdmin(id);
//    }

    public void updateStudent() throws Exception{
        studentBo.updateStudent(student);
    }
    public void updateTeacher() throws Exception{
        teacherBo.updateTeacher(teacher);
    }
//    public void updateAdmin() throws Exception{
//        adminBo.updateAdmin(admin);
//    }


    public List<Teacher> getTeacherList() {
        return teacherList;
    }

    public void setTeacherList(List<Teacher> teacherList) {
        this.teacherList = teacherList;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public String listTeacher() throws Exception{
        teacherList = teacherBo.listTeacher();
        return "success";
    }

    public String listStudentByName(String name) throws Exception{
        studentList = studentBo.getStudentsByName(name);
        return "success";
    }

    public String listStudentByClass(String classId) throws Exception{
        studentList = studentBo.getStudentsByClass(classId);
        return "success";
    }
}
