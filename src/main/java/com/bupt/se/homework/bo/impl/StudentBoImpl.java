package com.bupt.se.homework.bo.impl;

import com.bupt.se.homework.bo.ReturnCode;
import com.bupt.se.homework.bo.StudentBo;
import com.bupt.se.homework.dao.BasicDao;
import com.bupt.se.homework.dao.StudentDAO;
import com.bupt.se.homework.entity.Course;
import com.bupt.se.homework.entity.Student;
import com.bupt.se.homework.entity.StudentCourse;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

public class StudentBoImpl extends BasicBoImpl<Student, String> implements StudentBo {

    private StudentDAO studentDAO;

    @Autowired
    public void setStudentDAO(BasicDao<Student, String> basicDao) {
        super.setBasicDao(basicDao);
        this.studentDAO = (StudentDAO) basicDao;
    }

    @Override
    public boolean addStudent(Student student) {
        return studentDAO.save(student);
    }

    @Override
    public boolean deleteStudent(String id) {
        return studentDAO.delete(id);
    }

    @Override
    public boolean updateStudent(Student student) {
        return studentDAO.update(student);
    }

    @Override
    public List<Student> getStudentsByClass(String classId) {
        LinkedHashMap<Object, Object> equals = new LinkedHashMap<>();
        equals.put("classId", classId);
        return studentDAO.findResultList(equals, null, null, null, null, null, 0, 0);
    }

    @Override
    public List<Student> getStudentsByName(String name) {
        LinkedHashMap<Object, Object> equals = new LinkedHashMap<>();
        equals.put("studentName", name);
        return studentDAO.findResultList(equals, null, null, null, null, null, 0, 0);
    }

    @Override
    public Set<StudentCourse> getStudentCourse(Student student) {
        return student.getStudentCourses();
    }

    @Override
    public List<Course> getCourseList(Student student) {
        List<Course> list = null;
        Set<StudentCourse> studentCourses = this.getStudentCourse(student);
        if (studentCourses != null && studentCourses.size() > 0) {
            list = new ArrayList<>();
            for (StudentCourse sc:studentCourses) {
                list.add(sc.getCourse());
            }
        }
        return list;
    }

    @Override
    public String login(String id, String password) {
        Student student = studentDAO.get(id);
        if (student == null) return ReturnCode.USER_NOT_FOUNT;
        if (!student.getPassword().equals(password)) return ReturnCode.WRONG_PASSWORD;
        if (student.getPassword().equals(student.getStudentId())) return ReturnCode.FIRST_LOGIN;
        return ReturnCode.LOGIN_SUCCESS;
    }
}
