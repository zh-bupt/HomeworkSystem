package com.bupt.se.homework.action;

import com.bupt.se.homework.bo.AdminBo;
import com.bupt.se.homework.bo.StudentBo;
import com.bupt.se.homework.bo.TeacherBo;
import com.bupt.se.homework.entity.Admin;
import com.bupt.se.homework.entity.Student;
import com.bupt.se.homework.entity.Teacher;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @ClassName: AdminAction
 * @Description: 负责处理管理员界面上的操作
 * @Author: KRF
 * @Create: 2018/11/09
 **/


public class AdminAction extends ActionSupport {
    private AdminBo adminBo;
    private StudentBo studentBo;
    private TeacherBo teacherBo;
    private Student student = new Student();
    private Teacher teacher = new Teacher();
    private Admin admin = new Admin();

    List<Teacher> teacherList = new ArrayList<Teacher>();
    List<Student> studentList = new ArrayList<Student>();

    File studentExcel;//上传的文件
    String studentExcelContentType;//上传的文件类型
    String studentExcelFileName; //上传的文件名

    public File getStudentExcel() {
        return studentExcel;
    }

    public void setStudentExcel(File studentExcel) {
        this.studentExcel = studentExcel;
    }

    public String getStudentExcelContentType() {
        return studentExcelContentType;
    }

    public void setStudentExcelContentType(String studentExcelContentType) {
        this.studentExcelContentType = studentExcelContentType;
    }

    public String getStudentExcelFileName() {
        return studentExcelFileName;
    }

    public void setStudentExcelFileName(String studentExcelFileName) {
        this.studentExcelFileName = studentExcelFileName;
    }

    public void setStudentBo(StudentBo studentBo) {
        this.studentBo = studentBo;
    }

    public void setTeacherBo(TeacherBo teacherBo) {
        this.teacherBo = teacherBo;
    }

    public void setAdminBo(AdminBo adminBo) {
        this.adminBo = adminBo;
    }


    public String addStudent() throws Exception{
        studentBo.addStudent(student);
        return "success";
    }

    public String addTeacher() throws Exception{
        teacherBo.addTeacher(teacher);
        return "success";
    }
//    public void addAdmin() throws Exception{
//        adminBo.addAdmin(admin);
//    }

    public String deleteStudent(String id) throws Exception{
        studentBo.deleteStudent(id);
        return "success";
    }
    public String deleteTeacher(String id) throws Exception{
        teacherBo.deleteTeacher(id);
        return "success";
    }
//    public void deleteAdmin(String id) throws Exception{
//        adminBo.deleteAdmin(id);
//    }

    public String updateStudent() throws Exception{
        studentBo.updateStudent(student);
        return "success";
    }
    public String updateTeacher() throws Exception{
        teacherBo.updateTeacher(teacher);
        return "success";
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
        System.out.println("courseList size = "+teacherList.size());
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

    public void setStudentName(String studentName) {
        this.student.setStudentName(studentName);
    }

    public void setStudentId(String studentId) {
        this.student.setStudentId(studentId);
    }


    public void setClassId(String classId) {
        this.student.setClassId(classId);
    }

    public void setSex(String sex) {
        this.student.setSex(sex);
    }

    public void setEmail(String email) {
        this.student.setEmail(email);
    }

    public void setPassword(String password) {
        this.student.setPassword(password);
    }

    public void setEntranceDate(Date date){
        this.student.setEntranceDate(date);
    }

    public void setTeacherId(String teacherId) {
        this.teacher.setTeacherId(teacherId);
    }

    public void setTeacherName(String teacherName) {
        this.teacher.setTeacherName(teacherName);
    }

    public void setTeacherSex(String teacherSex) {
        this.teacher.setSex(teacherSex);
    }

    public void setProfession(String profession) {
        this.teacher.setProfession(profession);
    }

    public void setTelephone(String telephone) {
        this.teacher.setTelephone(telephone);
    }

    public void setTeacherEmail(String teacherEmail) {
        this.teacher.setEmail(teacherEmail);
    }

    public void setTeacherPassword(String teacherPassword) {
        this.teacher.setPassword(teacherPassword);
    }

    public String addStudentByFile() throws Exception {

        System.out.println("FileName:"+this.getStudentExcelFileName());
        System.out.println("ContentType:"+this.getStudentExcelContentType());
        System.out.println("File:"+this.getStudentExcel());

        //获取要保存文件夹的物理路径(绝对路径)
        String realPath= ServletActionContext.getServletContext().getRealPath("/upload/admin");
        File file = new File(realPath);

        //测试此抽象路径名表示的文件或目录是否存在。若不存在，创建此抽象路径名指定的目录，包括所有必需但不存在的父目录。
        if(!file.exists())
            file.mkdirs();

        try {
            //保存文件
            FileUtils.copyFile(studentExcel, new File(file,studentExcelFileName));
            //传文件给studentBo
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "success";
    }
}
