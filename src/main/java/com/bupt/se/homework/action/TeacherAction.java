package com.bupt.se.homework.action;

import com.bupt.se.homework.bo.CourseBo;
import com.bupt.se.homework.bo.HomeworkBo;
import com.bupt.se.homework.bo.StudentBo;
import com.bupt.se.homework.bo.TeacherBo;
import com.bupt.se.homework.bo.impl.CourseBoImpl;
import com.bupt.se.homework.bo.impl.StudentBoImpl;
import com.bupt.se.homework.entity.Course;
import com.bupt.se.homework.entity.Homework;
import com.bupt.se.homework.entity.Student;
import com.bupt.se.homework.entity.Teacher;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class TeacherAction extends ActionSupport {

    private List<Course> courseList = new ArrayList<Course>();
    private List<Student> studentList = new ArrayList<Student>();
    private List<Homework> homeworkList = new ArrayList<Homework>();



    private TeacherBo teacherBo;// = new TeacherBoImpl();
    private Teacher teacher = new Teacher();

    private Course course = new Course();
    private CourseBo courseBo;

    private Student student = new Student();
    private StudentBo studentBo;

    private Homework homework = new Homework();
    private HomeworkBo homeworkBo;

    private File studentExcel;//上传的文件
    private String studentExcelContentType;//上传的文件类型
    private String studentExcelFileName; //上传的文件名

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

    public void setStudentBo(StudentBoImpl studentBo) {
        this.studentBo = studentBo;
    }

    public void setCourseBo(CourseBoImpl courseBo) {
        this.courseBo = courseBo;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public List<Homework> getHomeworkList() {
        return homeworkList;
    }

    public void setHomeworkList(List<Homework> homeworkList) {
        this.homeworkList = homeworkList;
    }

    public void setTeacherName(String teacherName) {
        this.teacher.setTeacherName(teacherName);
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


    /**
     * @Author KRF
     * @Description 添加课程，添加结束输出该教师的所有课程
     * @Date 18:23 2018/11/11
     * @Param []
     * @return java.lang.String
     **/

    public String addCourse() throws Exception{
        Map<String, Object> session = ActionContext.getContext().getSession();
        teacher = teacherBo.get(session.get("id").toString());
        course.setCreateTime(new Date());
        course.setTeacher(teacher);
        System.out.println(teacher.getTeacherName());
        courseBo.addCourse(course);
        //listCourse();
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
        homework.setReleaseTime(new Date());
        Map<String, Object> session = ActionContext.getContext().getSession();
        course = courseBo.get(session.get("courseId").toString());
        System.out.println(course.getCourseId());
        homework.setCourse(course);
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

    public String addStudentForCourseByType()
    {


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


    public void setHomeworkId(String homeworkId) {
        this.homework.setHomeworkId(Integer.valueOf(homeworkId));
    }

    public void setContent(String content) {
        this.homework.setContent(content);
    }

    public void setDeadline(String deadline) throws Exception {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("YYYY-MM-DD");
        this.homework.setDeadline(simpleDateFormat.parse(deadline));
    }

    /**
     * @Author KRF
     * @Description 列出该课程的学生列表和作业列表
     * @Date 18:36 2018/11/20
     * @Param []
     * @return java.lang.String
     **/

    public String listStudentAndHomework() throws Exception {
        Map<String, Object> session = ActionContext.getContext().getSession();
        course = courseBo.get(session.get("courseId").toString());
        System.out.println(course.getCourseId());
        studentList = courseBo.getStudents(course);
        //homeworkList = courseBo.getHomework(course);TODO 等张珩实现此方法
        Set<Homework> homeworkSet = course.getHomework();
        System.out.println("HomeworkList SIZE"+homeworkSet.size());
        homeworkList = null;
        if (homeworkSet != null && homeworkSet.size() > 0) {

            homeworkList.addAll(homeworkSet);
        }

        return "success";
    }


    /**
     * @Author KRF
     * @Description 将课程id 存入session中，这样每次刷新就可以读取id
     * @Date 19:52 2018/11/20
     * @Param []
     * @return java.lang.String
     **/

    public String setSessionCourse() throws Exception {
        Map<String, Object> session = ActionContext.getContext().getSession();
        session.put("courseId",course.getCourseId());
        return "success";
    }

    public void setStudentId(String studentId) {
        student.setStudentId(studentId);
    }

    public CourseBo getCourseBo() {
        return this.courseBo;
    }
}
