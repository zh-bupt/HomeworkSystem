package com.bupt.se.homework.action;

import com.bupt.se.homework.bo.*;
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
    private Group_ group = new Group_();
    private GroupBo groupBo;
    private List<String> studentIdList = new ArrayList<>();
    private List<Group_> groupManagedList = new ArrayList<>();
    private GroupStudentBo groupStudentBo;
    private List<Student> noGroupStudentList =  new ArrayList<>();

    public List<Student> getNoGroupStudentList() {
        return noGroupStudentList;
    }

    public void setNoGroupStudentList(List<Student> noGroupStudentList) {
        this.noGroupStudentList = noGroupStudentList;
    }


    public GroupStudentBo getGroupStudentBo() {
        return groupStudentBo;
    }

    public void setGroupStudentBo(GroupStudentBo groupStudentBo) {
        this.groupStudentBo = groupStudentBo;
    }

    public List<Group_> getGroupManagedList() {
        return groupManagedList;
    }

    public void setGroupManagedList(List<Group_> groupManagedList) {
        this.groupManagedList = groupManagedList;
    }

    public GroupBo getGroupBo() {
        return groupBo;
    }

    public void setGroupBo(GroupBo groupBo) {
        this.groupBo = groupBo;
    }

    public List<String> getStudentIdList() {
        return studentIdList;
    }

    public void setStudentIdList(List<String> studentIdList) {
        this.studentIdList = studentIdList;
    }

    public Group_ getGroup() {
        return group;
    }

    public void setGroup(Group_ group) {
        this.group = group;
    }

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

    public String listCourseAndGroup() throws Exception {
        Map<String, Object> session = ActionContext.getContext().getSession();
        student = studentBo.get(session.get("id").toString());
        Set<StudentCourse> studentCourses = student.getStudentCourses();
        System.out.println("studentCourses.size():"+studentCourses.size());
        groupManagedList.addAll(student.getGroupsManaged());
        System.out.println("groupManagedList-->"+groupManagedList+" "+groupManagedList.get(0).getGroupId()+" "+groupManagedList.get(0).getName());
        for(StudentCourse sc : studentCourses)
        {
            courseList.add(sc.getCourse());
        }
        for(GroupStudent gs : groupManagedList.get(0).getGroupStudentSet())
        {
            System.out.println(gs.getStudent().getStudentName());
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
        // TODO 已经实现, 简单测试了一下
        Group_ group_ = studentBo.getCourseGroup(session.get("id").toString(),session.get("courseId").toString());

        //获取要保存文件夹的物理路径(绝对路径)
        String relativePath = "/upload/course/"+session.get("courseId").toString()+"/"+session.get("homeworkId").toString()+"/";
        String realPath= ServletActionContext.getServletContext().getRealPath(relativePath);
        File file = new File(realPath);
        System.out.print(realPath);
        //测试此抽象路径名表示的文件或目录是否存在。若不存在，创建此抽象路径名指定的目录，包括所有必需但不存在的父目录。
        if(!file.exists())
        {
            file.mkdirs();
            System.out.println("创建了作业的目录");
        }
        try {
            //保存文件
            FileUtils.copyFile(groupHomework, new File(file,groupHomeworkFileName));
            //String result = getDataFromExcel(realPath+"\\"+studentExcelFileName);
            homeworkGroup.setFileDir(groupHomeworkFileName);
//            homeworkGroup.setHomework(homework);
//            homeworkGroup.setGroup_(group_);
            homeworkGroup.setSubmissionTime(new Date());
           // HomeworkGroupPK homeworkGroupPK = new HomeworkGroupPK(homework.getHomeworkId(),group_.getGroupId());
           // homeworkGroup.setPk(homeworkGroupPK);

            //homeworkGroupBo.update(homeworkGroup);

            homeworkGroupBo.merge(homeworkGroup);

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

    /**
     * @Author KRF
     * @Description 列出该课程的所有作业和该同学所在的小组
     * @Date 20:15 2018/11/22
     * @Param []
     * @return java.lang.String
     **/

    public String listHomeworkAndGroup() throws Exception {
        Map<String, Object> session = ActionContext.getContext().getSession();
        course = courseBo.get(session.get("courseId").toString());
        System.out.println(course.getCourseId());
        Set<Homework> homeworkSet = course.getHomework();
        System.out.println("HomeworkList SIZE"+homeworkSet.size());

        if (homeworkSet != null && homeworkSet.size() > 0) {

            homeworkList.addAll(homeworkSet);
        }
        Group_ group_ = studentBo.getCourseGroup(session.get("id").toString(),session.get("courseId").toString());
        System.out.println(group_.getGroupId());
        noGroupStudentList = groupStudentBo.findResultList(course.getCourseId());
        System.out.println("noGroupStudentList-->"+noGroupStudentList);
        return "success";
    }

    public String setSessionHomework() throws Exception {
        Map<String, Object> session = ActionContext.getContext().getSession();
        session.put("homeworkId",homework.getHomeworkId());
        return "success";
    }

    /**
     * @Author KRF
     * @Description 创建小组，存入数据库中
     * @Date 19:51 2018/11/22
     * @Param []
     * @return java.lang.String
     **/

    public String addGroup() throws Exception {

        Map<String, Object> session = ActionContext.getContext().getSession();
        course = courseBo.get(session.get("courseId").toString());
//        group.setCourse(course);
        student = studentBo.get(session.get("id").toString());

//        group.setLeader(student);
//        Set<GroupStudent> groupStudentSet =  new HashSet<>();
        Set<Student> studentSet = new HashSet<>();
        for(String id:studentIdList)
        {
            Student s = studentBo.get(id);
            studentSet.add(s);
            System.out.println(id);
            System.out.print(s);
//            GroupStudent groupStudent = new GroupStudent(group,s);
//            groupStudentSet.add(groupStudent);
        }
//        group.setMembers(studentSet);
//        group.setGroupStudentSet(groupStudentSet);
//        System.out.println(group);
        System.out.println(group.getGroupId()+group.getName()+String.valueOf(group.getNum()));
//        groupBo.merge(group);
        studentSet.add(student);
        groupBo.addGroup(group, course, student, studentSet);
        return "success";
    }

    public void setGroupId(String groupId) {
        this.group.setGroupId(groupId);
    }

    public void setName(String name) {
        this.group.setName(name);
    }

    public void setStudentIds(String studentIds) {
        String[] is = studentIds.split(",");
        for(String s:is)
        {
            System.out.println(s);
            studentIdList.add(s);
        }
        //studentIdList = Arrays.asList(studentIds.split("|"));
        this.group.setNum(studentIdList.size()+1);
    }
//
//
//    public String toStringStudentGroupSet(HashSet<GroupStudent> groupStudentSet)
//    {
//        String result = "";
//        if(groupStudentSet!=null && groupStudentSet.size()>0)
//        {
//            for(GroupStudent gs:groupStudentSet)
//            {
//                result = result + gs.getStudent().getStudentName()+" ";
//            }
//        }
//        return result;
//    }
}
