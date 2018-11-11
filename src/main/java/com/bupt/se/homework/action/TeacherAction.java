package com.bupt.se.homework.action;

import com.bupt.se.homework.bo.CourseBo;
import com.bupt.se.homework.bo.HomeworkBo;
import com.bupt.se.homework.bo.TeacherBo;
import com.bupt.se.homework.bo.impl.CourseBoImpl;
import com.bupt.se.homework.entity.Course;
import com.bupt.se.homework.entity.Homework;
import com.bupt.se.homework.entity.Teacher;
import com.opensymphony.xwork2.ModelDriven;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TeacherAction implements ModelDriven {

    Teacher teacher = new Teacher();
    List<Teacher> teacherList = new ArrayList<Teacher>();
    TeacherBo teacherBo;// = new TeacherBoImpl();


    Course course = new Course();
    CourseBo courseBo;

    Homework homework = new Homework();
    HomeworkBo homeworkBo;


    public void setHomeworkBo(HomeworkBo homeworkBo) {
        this.homeworkBo = homeworkBo;
    }

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
    /**
     * @Author KRF
     * @Description 添加课程，添加结束输出该教师的所有课程
     * @Date 18:23 2018/11/11
     * @Param []
     * @return java.lang.String
     **/

    public String addCourse() throws Exception{
        courseBo.addCourse(course);
        return "success";
    }

    /**
     * @Author KRF
     * @Description 发布作业
     * @Date 20:32 2018/11/11
     * @Param []
     * @return java.lang.String
     **/

    public String addHomework() throws Exception{
        homeworkBo.addHomework(homework);
        return "success";
    }

    /**
     * @Author KRF
     * @Description 列表输入方法为课程添加学生名单
     * @Date 20:35 2018/11/11
     * @Param []
     * @return java.lang.String
     **/

    public String addStudentCourseByType()
    {

        //TODO
        return "success";
    }

    /**
     * @Author KRF
     * @Description excel导入方式添加需要上此课程的学生名单
     * @Date 20:36 2018/11/11
     * @Param []
     * @return java.lang.String
     **/

    public String addStudentCourseByFile()
    {
        //TODO
        return "success";
    }

    public void setTeacherName(String teacherName) {
        this.teacher.setTeacherName(teacherName);
    }

    public void setCourseBo(CourseBoImpl courseBo) {
        this.courseBo = courseBo;
    }
}
