package com.bupt.se.homework.action;

import com.bupt.se.homework.bo.*;
import com.bupt.se.homework.bo.impl.CourseBoImpl;
import com.bupt.se.homework.bo.impl.StudentBoImpl;
import com.bupt.se.homework.bo.impl.StudentCourseBoImpl;
import com.bupt.se.homework.entity.*;
import com.bupt.se.homework.exception.ServiceException;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class TeacherAction extends ActionSupport {

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    private List<Course> courseList = new ArrayList<Course>();
    private List<Student> studentList = new ArrayList<Student>();
    private List<Homework> homeworkList = new ArrayList<Homework>();
    private List<HomeworkGroup> homeworkGroupList = new ArrayList<>();


    private TeacherBo teacherBo;// = new TeacherBoImpl();
    private Teacher teacher = new Teacher();

    private Course course = new Course();
    private CourseBo courseBo;

    private Student student = new Student();
    private StudentBo studentBo;


    private Homework homework = new Homework();
    private HomeworkBo homeworkBo;

    private StudentCourse studentCourse = new StudentCourse();
    private List<StudentCourse> studentCourseList = new ArrayList<>();
    private StudentCourseBo studentCourseBo;
    private File studentExcel;//上传的文件
    private String studentExcelContentType;//上传的文件类型
    private String studentExcelFileName; //上传的文件名

    private String homeworkFileName;
    private HomeworkGroup homeworkGroup = new HomeworkGroup();//貌似没用
    private HomeworkGroupBo homeworkGroupBo;
    private String groupId;

    private String homeworkId;

    private InputStream is;

    //为了下载成绩单
    private static final long serialVersionUID = 1L;
    private InputStream excelFile;
    private String fileName;

    public  void setCreateTime(Date createTime)
    {
        this.course.setCreateTime(createTime);
    }
    public void setReleaseTime(Date releaseTime)
    {
        this.homework.setReleaseTime(releaseTime);
    }
    public void setDeadline(Date deadline)
    {
        this.homework.setDeadline(deadline);
    }

    public Homework getHomework() {
        return homework;
    }

    public void setHomework(Homework homework) {
        this.homework = homework;
    }

    public void setMaxStudentNum(Integer maxStudentNum)
    {
        this.course.setMaxStudentNum(maxStudentNum);
    }
    public void setMinStudentNum(Integer minStudentNum)
    {
        this.course.setMinStudentNum(minStudentNum);
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public InputStream getIs() {
        return is;
    }

    public void setIs(InputStream is) {
        this.is = is;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getHomeworkId() {
        return homeworkId;
    }


    public HomeworkGroupBo getHomeworkGroupBo() {
        return homeworkGroupBo;
    }

    public void setHomeworkGroupBo(HomeworkGroupBo homeworkGroupBo) {
        this.homeworkGroupBo = homeworkGroupBo;
    }

    public void setFileDir(String fileDir)
    {
        this.homeworkFileName = fileDir;
    }

    public HomeworkGroup getHomeworkGroup() {
        return homeworkGroup;
    }

    public void setHomeworkGroup(HomeworkGroup homeworkGroup) {
        this.homeworkGroup = homeworkGroup;
    }

    public List<HomeworkGroup> getHomeworkGroupList() {
        return homeworkGroupList;
    }

    public void setHomeworkGroupList(List<HomeworkGroup> homeworkGroupList) {
        this.homeworkGroupList = homeworkGroupList;
    }

    public StudentCourse getStudentCourse() {
        return studentCourse;
    }

    public void setStudentCourse(StudentCourse studentCourse) {
        this.studentCourse = studentCourse;
    }

    public List<StudentCourse> getStudentCourseList() {
        return studentCourseList;
    }

    public void setStudentCourseList(List<StudentCourse> studentCourseList) {
        this.studentCourseList = studentCourseList;
    }

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

    public void setStudentCourseBo(StudentCourseBoImpl studentCourseBo) {
        this.studentCourseBo = studentCourseBo;
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

//    public void setCapacity(String capacity) {
//        this.course.setCapacity(Integer.valueOf(capacity));
//    }
    public void setScore(Integer score)
    {
        this.homeworkGroup.setScore(score);
    }

    public void setComment(String comment)
    {
        this.homeworkGroup.setComment(comment);
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
        try{
            courseBo.addCourse(course);
        }catch (Exception e)
        {
            e.printStackTrace();
            super.addActionError("课程ID已存在");
            return "error";
        }
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
        String courseId = session.get("courseId").toString();
        System.out.println(courseId);

        System.out.println("deadline---->" + homework.getDeadline());
        try {
            teacherBo.assignHomework(courseId, homework);
        } catch (Exception e) {
            e.printStackTrace();
        }
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
        student = studentBo.get(student.getStudentId());
        Map<String, Object> session = ActionContext.getContext().getSession();
        course = courseBo.get(session.get("courseId").toString());
        studentCourse.setCourse(course);
        studentCourse.setStudent(student);
        StudentCoursePK studentCoursePK = new StudentCoursePK(student.getStudentId(),course.getCourseId());
        studentCourse.setPk(studentCoursePK);
        studentCourseBo.save(studentCourse);
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
            FileUtils.copyFile(studentExcel, new File(file,studentExcelFileName));
            // bug-fix 文件分隔符问题, 应用File.separator代替"\\"
            String result = getDataFromExcel(realPath + File.separator + studentExcelFileName);
            return result;
            //传文件给studentBo
        } catch (IOException e) {
            e.printStackTrace();
            return "error";
        }

    }
    /**
     * @Author KRF
     * @Description 读取课程学生名单，只需要学号就够了，Excel可以包含学号、班级、姓名 待测试
     * @Date 22:09 2018/11/20
     * @Param [filePath]
     * @return java.lang.String
     **/

    public String getDataFromExcel(String filePath)
    {

        FileInputStream fis =null;
        Workbook workbook = null;
        int flag = 0;

        try
        {
            //获取一个绝对地址的流
            fis = new FileInputStream(filePath);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        try
        {
            //2003版本的excel，用.xls结尾
            workbook = new HSSFWorkbook(fis);//得到工作簿
        }
        catch (Exception ex)
        {
            try
            {
                //2007版本的excel，用.xlsx结尾
                fis = new FileInputStream(filePath);
                workbook = new XSSFWorkbook(fis);//得到工作簿
            } catch (IOException e)
            {
                e.printStackTrace();
            }
        }

        //得到一个工作表
        Sheet sheet = workbook.getSheetAt(0);

        //获得表头
        Row rowHead = sheet.getRow(0);

        //根据不同的data放置不同的表头
        Map<Object,Integer> headMap = new HashMap<Object, Integer>();
        try
        {
                //这里根据你的表格有多少列
                while (flag < 3)
                {
                    Cell cell = rowHead.getCell(flag);
                    switch (cell.getStringCellValue()){
                        case "班级":
                            headMap.put("classId",flag);
                            flag++;
                            break;
                        case "学号":
                            headMap.put("studentId",flag);
                            flag++;
                            break;
                        case "姓名":
                            headMap.put("studentName",flag);
                            flag++;
                            break;
                    }
            }
        } catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("表头不合规范，请修改后重新导入");
        }
        //获得数据的总行数
        int totalRowNum = sheet.getLastRowNum();
        System.out.println(totalRowNum);
        if(0 == totalRowNum)
        {
            System.out.println("Excel内没有数据！");
        }

        Cell cell_1 = null,cell_2 = null,cell_3 = null,cell_4 = null,cell_5 = null,cell_6 = null;
        List<StudentCourse> sclist = new ArrayList<StudentCourse>();
        //获得所有数据
        for(int i = 1 ; i <= totalRowNum ; i++)
        {
            //获得第i行对象
            Row row = sheet.getRow(i);

            try
            {
                cell_1 = row.getCell(headMap.get("classId"));
                cell_2 =row.getCell(headMap.get("studentId"));
                cell_3 = row.getCell(headMap.get("studentName"));
            } catch (Exception e)
            {
                e.printStackTrace();
                System.out.println("获取单元格错误");
            }
            try
            {
                String sid = cell_2.toString();
                System.out.println("studentId---->" + sid);
                Student s = studentBo.get(sid);
                if (s != null) {
                    // TODO bug-fix 之前的代码不能自动生成主键, 调用这个构造方法才能自动生成主键
                    // 单独调用setStudent和setCourse, StudentCoursePK为空, 需要自己正定(set)方法
                    // 其他几个实体类类似, 以后注意一下就行了
                    StudentCourse sc = new StudentCourse(s, course);
                    sclist.add(sc);
                }
            } catch (ClassCastException e)
            {
                    e.printStackTrace();
                    System.out.println("数据有错误!");
            }
        }
        System.out.println("sclist-->"+sclist);
//        System.out.println(studentCourseBo.save(sclist));
        try {
            studentCourseBo.save(sclist);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }




    /**
     * @Author KRF
     * @Description 列出这个教师的所有课程
     * @Date 14:59 2018/11/15
     * @Param []
     * @return java.lang.String
     **/

    public String listCourse() throws Exception {
        Map<String, Object> session = ActionContext.getContext().getSession();
        teacher = teacherBo.get(session.get("id").toString());
        courseList = teacher.getCourses();
        System.out.println(courseList.size());
//        courseList = courseBo.listCourse();
        return "success";
    }


    public void setHomeworkId(String homeworkId) {
        this.homeworkId = homeworkId;
        this.homework.setHomeworkId(Integer.valueOf(homeworkId));
    }

    public void setContent(String content) {
        this.homework.setContent(content);
    }

    public void setDeadline(String deadline) throws Exception {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("deadline="+deadline);
        this.homework.setDeadline(simpleDateFormat.parse(deadline));
        System.out.println(this.homework.getDeadline());
    }

    /**
     * @Author KRF
     * @Description 列出该课程的学生列表和作业列表
     * @Date 18:36 2018/11/20
     * @Param []
     * @return java.lang.String
     **/

    public String listStudent() throws Exception {
        Map<String, Object> session = ActionContext.getContext().getSession();
        System.out.println("Session-->"+session.toString());
        String courseId = session.get("courseId").toString();
        course = courseBo.get(session.get("courseId").toString());
        System.out.println("course-->"+course);
        studentList = courseBo.getStudentList(courseId);
        //homeworkList.addAll(course.getHomework());
        List<Homework> homeworkSet = course.getHomework();
        System.out.println("HomeworkList SIZE"+homeworkSet.size());

        if (homeworkSet != null && homeworkSet.size() > 0) {

            homeworkList.addAll(homeworkSet);
        }

        return "success";
    }
    public String listHomework() throws Exception {
        Map<String, Object> session = ActionContext.getContext().getSession();
        System.out.println("Session-->"+session.toString());
        course = courseBo.get(session.get("courseId").toString());
        System.out.println("course-->"+course);
        List<Homework> homeworkSet = course.getHomework();
        System.out.println("HomeworkList SIZE"+homeworkSet.size());

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


    public void setPercentage(String percentage) {
        this.homework.setPercentage(Integer.valueOf(percentage));
    }

    public void setGroupPrefix(String groupPrefix) {
        this.course.setGroupPrefix(groupPrefix);
    }

    /**
     * @Author KRF
     * @Description 删除该教师的课程
     * @Date 15:40 2018/11/22
     * @Param []
     * @return java.lang.String
     **/
    public String deleteCourse() throws Exception {
        //course = courseBo.get(course.getCourseId());
        courseBo.delete(course.getCourseId());
        return "success";
    }

    /**
     * @Author KRF
     * @Description 修改某门课的配置，如小组配置
     * @Date 15:46 2018/11/22
     * @Param []
     * @return java.lang.String
     **/

    public String updateCourse() throws Exception {
        Map<String, Object> session = ActionContext.getContext().getSession();
        //course.setCourseId(session.get("courseId").toString());
        //course = courseBo.get(session.get("courseId").toString());
        System.out.println("COURSE-->"+course.getCourseName()+course.getCourseId());
        course.setTeacher(teacherBo.get(session.get("id").toString()));
        courseBo.update(course);
        return "success";
    }

    /**
     * @Author KRF
     * @Description 删除某门课的某次作业
     * @Date 15:46 2018/11/22
     * @Param []
     * @return java.lang.String
     **/

    public String deleteHomework() throws Exception {

        System.out.println("homeworkId------>" + homework.getHomeworkId());
        homeworkBo.delete(homework.getHomeworkId());
        return "success";
    }

    /**
     * @Author KRF
     * @Description 删除某门课程的某个学生，使其不再能上此课
     * @Date 15:46 2018/11/22
     * @Param []
     * @return java.lang.String
     **/

    public String deleteStudentCourse() throws Exception {
        Map<String, Object> session = ActionContext.getContext().getSession();
//        course = courseBo.get(session.get("courseId").toString());
//        student = studentBo.get(student.getStudentId());
        studentCourseBo.delete(new StudentCoursePK(student.getStudentId(),session.get("courseId").toString()));
        return "success";
    }

    /**
     * @Author KRF
     * @Description 列出该门课该作业提交了的所有小组，并支持下载作业
     * @Date 15:50 2018/11/22
     * @Param []
     * @return java.lang.String
     **/

    public String listHomeworkGroup() throws Exception {
        Map<String, Object> session = ActionContext.getContext().getSession();
//        course = courseBo.get(session.get("courseId").toString());
//        course.getGroups();
        System.out.println("homeworkId-->"+session.get("homeworkId"));
        homework = homeworkBo.get((Integer) session.get("homeworkId"));
        homeworkGroupList.addAll(homework.getHomeworkGroups());
        return "success";
    }

    /**
     * @Author KRF
     * @Description  教师通过点击按钮下载学生的作业
     * @Date 16:05 2018/11/22
     * @Param []
     * @return java.lang.String
     **/

    public String downloadHomework() throws Exception {
        this.setIs(getDownloadFile());
        return "success";
    }
    /**
     * @Author KRF
     * @Description 获取所选小组的该课程的该次作业
     * @Date 21:15 2018/11/24
     * @Param []
     * @return java.io.InputStream
     **/

    public InputStream getDownloadFile() throws Exception{
//        String filePath = ServletActionContext.getRequest().getServletContext().getRealPath("/download/"+fileName);
        Map<String, Object> session = ActionContext.getContext().getSession();

//        course = courseBo.get(session.get("courseId").toString());
        String filePath = ServletActionContext.getServletContext().getRealPath("/upload/course/"+session.get("courseId").toString()+"/"+homeworkId+"/"+homeworkFileName);

        InputStream is = new FileInputStream(new File(filePath));
        return is;
    }

    public void setHomeworkFileName(String fileName) throws UnsupportedEncodingException {
        //处理get请求中文乱码
        System.out.println(fileName);
        this.homeworkFileName = new String(fileName.getBytes("iso8859-1"),"utf-8");
    }

    public String getHomeworkFileName() {
        return homeworkFileName;
    }

    /**
     * @Author KRF
     * @Description 导出某门课的成绩单
     * @Date 20:57 2018/11/24
     * @Param []
     * @return java.lang.String
     **/

    public String exportExcel() throws Exception {
        Map<String, Object> session = ActionContext.getContext().getSession();
        // TODO 数据库的问题应该解决了, 但是有新的错误, 应该是写文件的问题
        Map<Student,Double> scoreList = teacherBo.getCourseTranscript(session.get("id").toString(),session.get("courseId").toString());
        HSSFWorkbook workbook = exportExcel(scoreList);
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        workbook.write(output);
        byte[] ba = output.toByteArray();
        excelFile = new ByteArrayInputStream(ba);
        output.flush();
        output.close();
        return "exportExcel";
    }
    public HSSFWorkbook exportExcel(Map<Student,Double> scoreList) throws Exception {
        Map<String, Object> session = ActionContext.getContext().getSession();
        course = courseBo.get(session.get("courseId").toString());
        studentCourseList.addAll(course.getStudentCourses());
        fileName = course.getCourseName()+"成绩单.xls";
        //设置字符，防止乱码
        fileName= new String(fileName.getBytes("UTF-8"),"ISO8859-1");
        HSSFWorkbook wb;
        //根据studentList生成excel文件
        wb = new HSSFWorkbook();
        HSSFSheet sheet = wb.createSheet(course.getCourseName()+"成绩单");
        HSSFRow row=sheet.createRow(0);
        HSSFCell cell=row.createCell(0);
        cell.setCellValue("班级");
        cell=row.createCell(1);
        cell.setCellValue("学号");
        cell=row.createCell(2);
        cell.setCellValue("姓名");
        cell=row.createCell(3);
        cell.setCellValue("成绩");
        int count = 0;
        if(studentCourseList!=null&&studentCourseList.size()>0){
            for(StudentCourse sc:studentCourseList){
                Student s = sc.getStudent();
                row=sheet.createRow(count+1);
                cell=row.createCell(0);
                cell.setCellValue(s.getClassId());
                cell=row.createCell(1);
                cell.setCellValue(s.getStudentId());
                cell=row.createCell(2);
                cell.setCellValue(s.getStudentName());
                cell=row.createCell(3);
                cell.setCellValue(scoreList.get(s));
                count+=1;
            }
        }
        return wb;
    }

    /**
     * @Author KRF
     * @Description 提交批改作业的
     * @Date 20:24 2018/11/28
     * @Param []
     * @return java.lang.String
     **/

    public String checkHomework() throws Exception {
        System.out.println(homework.getHomeworkId()+groupId);
        Map<String, Object> session = ActionContext.getContext().getSession();
        HomeworkGroup hg = homeworkGroupBo.get(new HomeworkGroupPK((Integer) session.get("homeworkId"),session.get("groupId").toString()));
        System.out.println("hg-->"+hg);
        hg.setScore(homeworkGroup.getScore());
        hg.setComment(homeworkGroup.getComment());
        System.out.println("HomeworkGroup-->"+hg.getPk()+hg.getScore()+hg.getComment());
        homeworkGroupBo.update(hg);
        return "success";
    }

    public String setSessionGroup() throws Exception {
        Map<String, Object> session = ActionContext.getContext().getSession();
        session.put("groupId",groupId);
        System.out.println("session-->"+groupId);
        return "success";
    }

    public String setSessionHomework() throws Exception {
        Map<String, Object> session = ActionContext.getContext().getSession();
        session.put("homeworkId",homework.getHomeworkId());
        return "success";
    }

    public String setCurrentCourse() throws Exception {
        Map<String, Object> session = ActionContext.getContext().getSession();
        course = courseBo.get(session.get("courseId").toString());
        return "success";
    }

    public String setCurrentHomework() throws Exception {
        homework = homeworkBo.get(homework.getHomeworkId());
        return "success";
    }

    public String updateHomework() throws Exception {
        Homework modified = homeworkBo.getHomework(homework.getHomeworkId());
        modified.setReleaseTime(homework.getReleaseTime());
        modified.setDeadline(homework.getDeadline());
        modified.setContent(homework.getContent());
        modified.setPercentage(homework.getPercentage());
        try {
            homeworkBo.updateHomework(modified);
        } catch (ServiceException se) {
            se.printStackTrace();
            return "error";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "success";
    }
}
