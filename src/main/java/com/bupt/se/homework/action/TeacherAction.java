package com.bupt.se.homework.action;

import com.bupt.se.homework.bo.CourseBo;
import com.bupt.se.homework.bo.HomeworkBo;
import com.bupt.se.homework.bo.TeacherBo;
import com.bupt.se.homework.bo.impl.CourseBoImpl;
import com.bupt.se.homework.entity.Course;
import com.bupt.se.homework.entity.Homework;
import com.bupt.se.homework.entity.Teacher;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TeacherAction implements ModelDriven {

    Teacher teacher = new Teacher();
    List<Course> courseList = new ArrayList<Course>();
    TeacherBo teacherBo;// = new TeacherBoImpl();


    Course course = new Course();
    CourseBo courseBo;

    Homework homework = new Homework();
    HomeworkBo homeworkBo;

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

    public void setHomeworkBo(HomeworkBo homeworkBo) {
        this.homeworkBo = homeworkBo;
    }

    public void setTeacherBo(TeacherBo teacherBo) {
        this.teacherBo = teacherBo;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    @Override
    public Object getModel() {
        return teacher;
    }


//    public String addTeacher() throws Exception {
//        //save it
//        teacherBo.addTeacher(teacher);
//        //reload the hwsystem list
//        courseList = null;
//        courseList = teacherBo.listTeacher();
//        return "success";
//    }

//    public String listTeacher() throws Exception{
//        courseList = teacherBo.listTeacher();
//        return "success";
//    }
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

    public String addStudentByType()
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

    public String addStudentForCourseByFile()
    {
        System.out.println("FileName:"+this.getStudentExcelFileName());
        System.out.println("ContentType:"+this.getStudentExcelContentType());
        System.out.println("File:"+this.getStudentExcel());

        //获取要保存文件夹的物理路径(绝对路径)
        String realPath= ServletActionContext.getServletContext().getRealPath("/upload/course");
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


    public void setTeacherName(String teacherName) {
        this.teacher.setTeacherName(teacherName);
    }

    public void setCourseBo(CourseBoImpl courseBo) {
        this.courseBo = courseBo;
    }

    /**
     * @Author KRF
     * @Description 列出这个教师的所有课程
     * @Date 14:59 2018/11/15
     * @Param []
     * @return java.lang.String
     **/

    public String listCourse() throws Exception {
        courseList = courseBo.listCourse();
        return "success";
    }

    public void setCourseId(String courseId) {
        this.course.setCourseId(courseId);
    }

    public void setCourseName(String courseName) {
        this.course.setCourseName(courseName);
    }

    public void setCapacity(String capacity) {
        this.course.setCapacity(Integer.valueOf(capacity));
    }
}
