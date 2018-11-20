package com.bupt.se.homework.action;

import com.bupt.se.homework.bo.CourseBo;
import com.bupt.se.homework.bo.HomeworkGroupBo;
import com.bupt.se.homework.bo.StudentBo;
import com.bupt.se.homework.entity.Course;
import com.bupt.se.homework.entity.HomeworkGroup;
import com.bupt.se.homework.entity.Student;
import com.bupt.se.homework.entity.StudentCourse;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class StudentAction implements ModelDriven {
    private Student student = new Student();
    private StudentBo studentBo;
    private CourseBo courseBo;
    private List<Course> courseList = new ArrayList<>();
    private Course course = new Course();
    private HomeworkGroupBo homeworkGroupBo;
    private File groupHomework;//上传的文件
    private String groupHomeworkContentType;//上传的文件类型
    private String groupHomeworkFileName; //上传的文件名
    private HomeworkGroup homeworkGroup = new HomeworkGroup();

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public HomeworkGroup getHomeworkGroup() {
        return homeworkGroup;
    }

    public void setHomeworkGroup(HomeworkGroup homeworkGroup) {
        this.homeworkGroup = homeworkGroup;
    }

    public HomeworkGroupBo getHomeworkGroupBo() {
        return homeworkGroupBo;
    }

    public void setHomeworkGroupBo(HomeworkGroupBo homeworkGroupBo) {
        this.homeworkGroupBo = homeworkGroupBo;
    }



    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    public File getGroupHomework() {
        return groupHomework;
    }

    public void setGroupHomework(File groupHomework) {
        this.groupHomework = groupHomework;
    }

    public String getGroupHomeworkContentType() {
        return groupHomeworkContentType;
    }

    public void setGroupHomeworkContentType(String groupHomeworkContentType) {
        this.groupHomeworkContentType = groupHomeworkContentType;
    }

    public String getGroupHomeworkFileName() {
        return groupHomeworkFileName;
    }

    public void setGroupHomeworkFileName(String groupHomeworkFileName) {
        this.groupHomeworkFileName = groupHomeworkFileName;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public StudentBo getStudentBo() {
        return studentBo;
    }

    public CourseBo getCourseBo() {
        return courseBo;
    }

    public void setCourseBo(CourseBo courseBo) {
        this.courseBo = courseBo;
    }

    @Override
    public Object getModel() {
        return student;
    }


    public void setStudentBo(StudentBo studentBo) {
        this.studentBo = studentBo;
    }

    public String listCourse() throws Exception {
        Map<String, Object> session = ActionContext.getContext().getSession();
        student = studentBo.get(session.get("id").toString());
        Set<StudentCourse> studentCourses = student.getStudentCourses();//TODO 等待张珩封装
        for(StudentCourse sc : studentCourses)
        {
            courseList.add(sc.getCourse());
        }
        return "success";
    }


//    public String addStudent() throws Exception {
//        studentBo.addStudent(student);
//        return "success";
//    }

    public String submitHomework()
    {
        System.out.println("FileName:"+this.getGroupHomeworkFileName());
        System.out.println("ContentType:"+this.getGroupHomeworkContentType());
        System.out.println("File:"+this.getGroupHomework());

        Map<String, Object> session = ActionContext.getContext().getSession();
        course = courseBo.get(session.get("courseId").toString());
        //获取要保存文件夹的物理路径(绝对路径)
        String realPath= ServletActionContext.getServletContext().getRealPath("/upload/course");
        File file = new File(realPath);


        //测试此抽象路径名表示的文件或目录是否存在。若不存在，创建此抽象路径名指定的目录，包括所有必需但不存在的父目录。
        if(!file.exists())
            file.mkdirs();

        try {
            //保存文件
            FileUtils.copyFile(groupHomework, new File(file,groupHomeworkFileName));
            //String result = getDataFromExcel(realPath+"\\"+studentExcelFileName);
            homeworkGroup.setFileDir(realPath);
            //TODO homeworkGroup.setHomework();
            //TODO homeworkGroup.setGroup_();

            homeworkGroupBo.save(homeworkGroup);
            //传文件给studentBo
        } catch (IOException e) {
            e.printStackTrace();
            return "error";
        }
        return "success";
    }

}
