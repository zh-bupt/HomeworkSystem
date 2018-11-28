package com.bupt.se.homework.action;

import com.bupt.se.homework.bo.AdminBo;
import com.bupt.se.homework.bo.StudentBo;
import com.bupt.se.homework.bo.TeacherBo;
import com.bupt.se.homework.entity.Admin;
import com.bupt.se.homework.entity.Student;
import com.bupt.se.homework.entity.Teacher;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.struts2.ServletActionContext;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

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

    private String searchWay;
    private String searchStudentWord;

    private String searchTeacherWord;

    private List<Teacher> teacherList = new ArrayList<Teacher>();
    private List<Student> studentList = new ArrayList<Student>();

    private File studentExcel;//上传的文件
    private String studentExcelContentType;//上传的文件类型
    private String studentExcelFileName; //上传的文件名
    private File teacherExcel;//上传的文件
    private String teacherExcelContentType;//上传的文件类型
    private String teacherExcelFileName; //上传的文件名

    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getSearchTeacherWord() {
        return searchTeacherWord;
    }

    public void setSearchTeacherWord(String searchTeacherWord) {
        this.searchTeacherWord = searchTeacherWord;
    }

    public String getSearchWay() {
        return searchWay;
    }

    public void setSearchWay(String searchWay) {
        this.searchWay = searchWay;
    }

    public String getSearchStudentWord() {
        return searchStudentWord;
    }

    public void setSearchStudentWord(String searchStudentWord) {
        this.searchStudentWord = searchStudentWord;
    }
    public File getTeacherExcel() {
        return teacherExcel;
    }

    public void setTeacherExcel(File teacherExcel) {
        this.teacherExcel = teacherExcel;
    }

    public String getTeacherExcelContentType() {
        return teacherExcelContentType;
    }

    public void setTeacherExcelContentType(String teacherExcelContentType) {
        this.teacherExcelContentType = teacherExcelContentType;
    }

    public String getTeacherExcelFileName() {
        return teacherExcelFileName;
    }

    public void setTeacherExcelFileName(String teacherExcelFileName) {
        this.teacherExcelFileName = teacherExcelFileName;
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
        System.out.println("teacherName-->"+teacher.getTeacherName());
        teacherBo.addTeacher(teacher);
        //listTeacher();
        return "success";
    }


    public String deleteStudent() throws Exception{
        studentBo.deleteStudent(student.getStudentId());
        return "success";
    }
    public String deleteTeacher() throws Exception{
        teacherBo.deleteTeacher(teacher.getTeacherId());
        //listTeacher();
        return "success";
    }

    public String updateStudent() throws Exception{
        studentBo.updateStudent(student);
        return "success";
    }
    public String updateTeacher() throws Exception{
        teacherBo.updateTeacher(teacher);
        //listTeacher();
        return "success";
    }



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

    public String listStudent() throws Exception {
        studentList = studentBo.getList(null,null,null,null,null,null,0,20);
        return "success";
    }
    public String queryStudent() throws Exception{
            LinkedHashMap<Object, Object> equals = new LinkedHashMap<>();
            equals.put("studentId", searchStudentWord);
            studentList = studentBo.getList(equals,null,null,null,null,null,0,0);
            studentList.addAll(studentBo.getStudentsByName(searchStudentWord));
            studentList.addAll(studentBo.getStudentsByClass(searchStudentWord));
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

    /**
     * @Author KRF
     * @Description 从浏览器上传Excel文件存入服务器中
     * @Date 14:25 2018/11/20
     * @Param []
     * @return java.lang.String
     **/

    public String addStudentByFile() throws Exception {

        System.out.println("FileName:"+this.getStudentExcelFileName());
        System.out.println("ContentType:"+this.getStudentExcelContentType());
        System.out.println("File:"+this.getStudentExcel());

        //获取要保存文件夹的物理路径(绝对路径)
        String realPath= ServletActionContext.getServletContext().getRealPath("/upload/admin/students");
        File file = new File(realPath);

        //测试此抽象路径名表示的文件或目录是否存在。若不存在，创建此抽象路径名指定的目录，包括所有必需但不存在的父目录。
        if(!file.exists())
            file.mkdirs();

        try {
            //保存文件
            FileUtils.copyFile(studentExcel, new File(file,studentExcelFileName));
            String result = getDataFromExcel(realPath+"\\"+studentExcelFileName,"学生");
            listTeacher();
            return result;
            //传文件给studentBo
        } catch (IOException e) {
            e.printStackTrace();
            return "error";
        }

    }
    public String addTeacherByFile() throws Exception {

        System.out.println("FileName:"+this.getTeacherExcelFileName());
        System.out.println("ContentType:"+this.getTeacherExcelContentType());
        System.out.println("File:"+this.getTeacherExcel());

        //获取要保存文件夹的物理路径(绝对路径)
        String realPath= ServletActionContext.getServletContext().getRealPath("/upload/admin/teachers");
        File file = new File(realPath);

        //测试此抽象路径名表示的文件或目录是否存在。若不存在，创建此抽象路径名指定的目录，包括所有必需但不存在的父目录。
        if(!file.exists())
            file.mkdirs();

        try {
            //保存文件
            FileUtils.copyFile(teacherExcel, new File(file,teacherExcelFileName));
            String result = getDataFromExcel(realPath+"\\"+teacherExcelFileName,"老师");
            listTeacher();
            return result;
            //传文件给studentBo
        } catch (IOException e) {
            e.printStackTrace();
            return "error";
        }

    }

    /**
     * @Author KRF
     * @Description 读取Excel文件，将学生名单存入数据库
     * @Date 13:36 2018/11/20
     * @Param [filePath,userType]  filePath excel文件的绝对路径， userType 用户类型表示是存入学生还是存入老师
     * @return String
     **/

    public String getDataFromExcel(String filePath,String userType)
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
            if(userType.equals("学生"))
            {
                //这里根据你的表格有多少列
                while (flag < 6)
                {
                    Cell cell = rowHead.getCell(flag);
                    switch (cell.getStringCellValue().toString()){
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
                        case "性别":
                            headMap.put("sex",flag);
                            flag++;
                            break;
                        case "邮箱":
                            headMap.put("email",flag);
                            flag++;
                            break;
                        case "入学时间":
                            headMap.put("entranceDate",flag);
                            flag++;
                            break;
                    }

                }
            }
            else if(userType.equals("老师"))
            {
                //这里根据你的表格有多少列
                while (flag < 6)
                {
                    Cell cell = rowHead.getCell(flag);
                    switch (cell.getStringCellValue().toString()){
                        case "工号":
                            headMap.put("teacherId",flag);
                            flag++;
                            break;
                        case "姓名":
                            headMap.put("teacherName",flag);
                            flag++;
                            break;
                        case "性别":
                            headMap.put("sex",flag);
                            flag++;
                            break;
                        case "职称":
                            headMap.put("profession",flag);
                            flag++;
                            break;
                        case "手机":
                            headMap.put("telephone",flag);
                            flag++;
                            break;
                        case "邮箱":
                            headMap.put("email",flag);
                            flag++;
                            break;

                    }

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
        if(userType.equals("学生"))
        {

            List<Student> slist = new ArrayList<Student>();
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
                    cell_4 = row.getCell(headMap.get("sex"));
                    cell_5 = row.getCell(headMap.get("email"));
                    cell_6 = row.getCell(headMap.get("entranceDate"));
                } catch (Exception e)
                {
                    e.printStackTrace();
                    System.out.println("获取单元格错误");
                }
                Student s = new Student();
                try
                {
                    s.setClassId(cell_1.toString());

                    s.setStudentId(cell_2.toString());
                    s.setStudentName(cell_3.toString());
                    s.setSex(cell_4.toString());
                    s.setEmail(cell_5.toString());
                    s.setEntranceDate(cell_6.getDateCellValue());//TODO 这里可能出错

                    s.setPassword(cell_2.toString());//密码就是初始学号
                    System.out.println(cell_1.toString()+cell_2.toString()+cell_3.toString()+cell_4.toString()+cell_5.toString()+cell_6.getDateCellValue());
                } catch (ClassCastException e)
                {
                    e.printStackTrace();
                    System.out.println("数据有错误!");
                }
                slist.add(s);

            }
           try {
                studentBo.save(slist);
               return "success";
           } catch (Exception e) {
               return "error";
           }

        }
        else if (userType.equals("老师"))
        {
            List<Teacher> tlist = new ArrayList<Teacher>();
            //获得所有数据
            for(int i = 1 ; i <= totalRowNum ; i++)
            {
                //获得第i行对象
                Row row = sheet.getRow(i);

                try
                {
                    cell_1 = row.getCell(headMap.get("teacherId"));
                    cell_2 =row.getCell(headMap.get("teacherName"));
                    cell_3 = row.getCell(headMap.get("sex"));
                    cell_4 = row.getCell(headMap.get("profession"));
                    cell_5 = row.getCell(headMap.get("telephone"));
                    cell_6 = row.getCell(headMap.get("email"));
                } catch (Exception e)
                {
                    e.printStackTrace();
                    System.out.println("获取单元格错误");
                }
               Teacher t = new Teacher();
                try
                {
                    t.setTeacherId(cell_1.toString());
                    t.setTeacherName(cell_2.toString());
                    t.setSex(cell_3.toString());
                    t.setProfession(cell_4.toString());
                    t.setTelephone(cell_5.toString());
                    t.setEmail(cell_6.toString());

                    t.setPassword(cell_1.toString());//工号就是初始密码

                } catch (ClassCastException e)
                {
                    e.printStackTrace();
                    System.out.println("数据有错误!");
                }
                tlist.add(t);

            }
            try {
                teacherBo.save(tlist);
                return "success";
            } catch (Exception e) {
                e.printStackTrace();
                return "error";
            }
        }
        else
        {
            System.out.println("用户类型错误");
            return "error";//既不是老师，也不是学生
        }
    }


    /**
     * @Author KRF
     * @Description 按照工号和姓名查询老师
     * @Date 11:33 2018/11/26
     * @Param []
     * @return java.lang.String
     **/
    
    public String queryTeacher() throws Exception {
        if(searchTeacherWord == null || searchTeacherWord.equals(""))
        {
            super.addActionError("查询不能为空！");
            return "error";
        }
        LinkedHashMap<Object, Object> equals = new LinkedHashMap<>();
        equals.put("teacherId", searchTeacherWord);
        teacherList = teacherBo.getList(equals,null,null,null,null,null,0,0);
        LinkedHashMap<Object, Object> equals1 = new LinkedHashMap<>();
        equals1.put("teacherName", searchTeacherWord);
        teacherList.addAll(teacherBo.getList(equals1,null,null,null,null,null,0,0));
        return "success";
    }

    public String setSessionUser() throws Exception {
        Map<String, Object> session = ActionContext.getContext().getSession();
        session.put("userId",userId);
        return "success";
    }


}
