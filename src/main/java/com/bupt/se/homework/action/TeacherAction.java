package com.bupt.se.homework.action;

import com.bupt.se.homework.bo.TeacherBo;
import com.bupt.se.homework.entity.Teacher;
import com.opensymphony.xwork2.ModelDriven;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TeacherAction implements ModelDriven {

    Teacher teacher = new Teacher();
    List<Teacher> teacherList = new ArrayList<Teacher>();
    TeacherBo teacherBo;// = new TeacherBoImpl();
    //DI via Spring

    public void setTeacherBo(TeacherBo teacherBo) {
        this.teacherBo = teacherBo;
    }

    public List<Teacher> getTeacherList() {
        return teacherList;
    }

    public void setTeacherList(List<Teacher> teacherList) {
        this.teacherList = teacherList;
    }

    @Override
    public Object getModel() {
        return teacher;
    }

    //save hwsystem
    public String addTeacher() throws Exception {
        //save it
        teacherBo.addTeacher(teacher);
        //reload the hwsystem list
        teacherList = null;
        teacherList = teacherBo.listTeacher();
        return "success";
    }

    public String listTeacher() throws Exception{
        teacherList = teacherBo.listTeacher();
        return "success";
    }


    public void setTeacherName(String teacherName) {
        this.teacher.setTeacherName(teacherName);
    }
}
