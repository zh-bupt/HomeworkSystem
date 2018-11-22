package com.bupt.se.homework.action;

import com.bupt.se.homework.bo.CourseBo;
import com.bupt.se.homework.bo.HomeworkBo;
import com.bupt.se.homework.bo.HomeworkGroupBo;
import com.bupt.se.homework.bo.StudentBo;
import com.bupt.se.homework.entity.*;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class StudentAction{
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
    private List<Homework> homeworkList = new ArrayList<>();
    private Homework homework = new Homework();
    private HomeworkBo homeworkBo;

    public HomeworkBo getHomeworkBo() {
        return homeworkBo;
    }

    public void setHomeworkBo(HomeworkBo homeworkBo) {
        this.homeworkBo = homeworkBo;
    }

    public Homework getHomework() {
        return homework;
    }

    public void setHomework(Homework homework) {
        this.homework = homework;
    }

    public List<Homework> getHomeworkList() {
        return homeworkList;
    }

    public void setHomeworkList(List<Homework> homeworkList) {
        this.homeworkList = homeworkList;
    }

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

    public void setCourseId(String courseId) {
        this.course.setCourseId(courseId);
    }

    public void setHomeworkId(String homeworkId){
        this.homework.setHomeworkId(Integer.valueOf(homeworkId));
    }

    public void setStudentBo(StudentBo studentBo) {
        this.studentBo = studentBo;
    }

    public String listCourse() throws Exception {
        Map<String, Object> session = ActionContext.getContext().getSession();
        student = studentBo.get(session.get("id").toString());
        Set<StudentCourse> studentCourses = student.getStudentCourses();//TODO 等待张珩封装
        System.out.println("studentCourses.size():"+studentCourses.size());
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

    /**
     * @Author KRF
     * @Description 提交作业，学生选择文件提交，文件保存在文件系统，不存入数据库，只存入路径
     * @Date 15:31 2018/11/22
     * @Param []
     * @return java.lang.String
     **/

    public String submitHomework()
    {
        System.out.println("FileName:"+this.getGroupHomeworkFileName());
        System.out.println("ContentType:"+this.getGroupHomeworkContentType());
        System.out.println("File:"+this.getGroupHomework());

        Map<String, Object> session = ActionContext.getContext().getSession();
        //course = courseBo.get(session.get("courseId").toString());
        homework = homeworkBo.get(Integer.valueOf(session.get("homeworkId").toString()));
        student = studentBo.get(session.get("id").toString());
        homeworkGroup = studentBo.getHomeworkGroup(student,homework);
        System.out.print(homeworkGroup);
        //Group_ group_ = studentBo.getCourseGroup(session.get("id").toString(),session.get("courseId").toString());//TODO 该方法待实现
        //获取要保存文件夹的物理路径(绝对路径)
        String realPath= ServletActionContext.getServletContext().getRealPath("/upload/course/"+session.get("courseId").toString()+"/"+session.get("homeworkId").toString()+"/");
        File file = new File(realPath);
        System.out.print(realPath);
        //测试此抽象路径名表示的文件或目录是否存在。若不存在，创建此抽象路径名指定的目录，包括所有必需但不存在的父目录。
        if(!file.exists())
            file.mkdirs();
        try {
            //保存文件
            FileUtils.copyFile(groupHomework, new File(file,groupHomeworkFileName));
            //String result = getDataFromExcel(realPath+"\\"+studentExcelFileName);
            homeworkGroup.setFileDir(realPath+groupHomeworkFileName);
//            homeworkGroup.setHomework(homework);
//            homeworkGroup.setGroup_(group_);
            homeworkGroup.setSubmissionTime(new Date());
           // HomeworkGroupPK homeworkGroupPK = new HomeworkGroupPK(homework.getHomeworkId(),group_.getGroupId());
           // homeworkGroup.setPk(homeworkGroupPK);
            homeworkGroupBo.save(homeworkGroup);
            //传文件给studentBo
        } catch (IOException e) {
            e.printStackTrace();
            return "error";
        }
        return "success";
    }

    public String setSessionCourse() throws Exception {
        Map<String, Object> session = ActionContext.getContext().getSession();
        session.put("courseId",course.getCourseId());
        return "success";
    }

    public String listHomework() throws Exception {
        Map<String, Object> session = ActionContext.getContext().getSession();
        course = courseBo.get(session.get("courseId").toString());
        System.out.println(course.getCourseId());
        Set<Homework> homeworkSet = course.getHomework();
        System.out.println("HomeworkList SIZE"+homeworkSet.size());

        if (homeworkSet != null && homeworkSet.size() > 0) {

            homeworkList.addAll(homeworkSet);
        }
        return "success";
    }

    public String setSessionHomework() throws Exception {
        Map<String, Object> session = ActionContext.getContext().getSession();
        session.put("homeworkId",homework.getHomeworkId());
        return "success";
    }
}
