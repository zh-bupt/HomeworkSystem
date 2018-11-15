package com.bupt.se.homework.action;

import com.bupt.se.homework.bo.StudentBo;
import com.bupt.se.homework.entity.Student;
import com.opensymphony.xwork2.ModelDriven;

import java.util.Date;

public class StudentAction implements ModelDriven {
    Student student = new Student();
    StudentBo studentBo;

    @Override
    public Object getModel() {
        return student;
    }


    public void setStudentBo(StudentBo studentBo) {
        this.studentBo = studentBo;
    }

//    public String addStudent() throws Exception {
//        studentBo.addStudent(student);
//        return "success";
//    }



}
