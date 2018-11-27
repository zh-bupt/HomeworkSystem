package com.bupt.se.homework.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "student")
public class Student extends AbstractEntity {

    private String studentId;
    private String studentName;
    private String classId;
    private String sex;
    private Date entranceDate;
    private String password;
    private String email;
    private List<StudentCourse> studentCourses = new ArrayList<>();
    private List<Group_> groupsManaged = new ArrayList<Group_>();
    private List<GroupStudent> groupStudentList = new ArrayList<GroupStudent>();
    private List<StudentHomework> studentHomeworkList = new ArrayList<StudentHomework>();

    public Student() {
    }

    public Student(String studentId, String studentName, String password) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.password = password;
    }

    @OneToMany(mappedBy = "student", cascade = {CascadeType.ALL, CascadeType.REMOVE}, fetch = FetchType.LAZY)
    public List<StudentCourse> getStudentCourses() {
        return studentCourses;
    }

    public void setStudentCourses(List<StudentCourse> studentCourses) {
        this.studentCourses = studentCourses;
    }

    @OneToMany(mappedBy = "student", cascade = {CascadeType.ALL, CascadeType.REMOVE})
    public List<GroupStudent> getGroupStudentList() {
        return groupStudentList;
    }

    public void setGroupStudentList(List<GroupStudent> groupStudentList) {
        this.groupStudentList = groupStudentList;
    }

    @OneToMany(cascade = {CascadeType.ALL, CascadeType.DETACH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "leaderId")
    public List<Group_> getGroupsManaged() {
        return groupsManaged;
    }

    public void setGroupsManaged(List<Group_> groupsManaged) {
        this.groupsManaged = groupsManaged;
    }

    @OneToMany(mappedBy = "student", cascade = {CascadeType.ALL, CascadeType.REMOVE}, fetch = FetchType.LAZY)
    public List<StudentHomework> getStudentHomeworkList() {
        return studentHomeworkList;
    }

    public void setStudentHomeworkList(List<StudentHomework> studentHomeworkList) {
        this.studentHomeworkList = studentHomeworkList;
    }

    @Basic
    @Column(length = 20, nullable = false)
    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    @Basic
    @Column(length = 20)
    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    @Basic
    @Column(length = 2)
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Basic
    @Column(columnDefinition = "DATE")
    public Date getEntranceDate() {
        return entranceDate;
    }

    public void setEntranceDate(Date entranceDate) {
        this.entranceDate = entranceDate;
    }

    @Basic
    @Column(length = 40, nullable = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(length = 40)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Id
    @Column(length = 10)
    @GeneratedValue(generator = "studentId")
    @GenericGenerator(name = "studentId", strategy = "assigned")
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(studentId, student.studentId) &&
                Objects.equals(studentName, student.studentName) &&
                Objects.equals(classId, student.classId) &&
                Objects.equals(sex, student.sex) &&
                Objects.equals(entranceDate, student.entranceDate) &&
                Objects.equals(password, student.password) &&
                Objects.equals(email, student.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, studentName, classId, sex, entranceDate, password, email);
    }

    @Override
    public void preRemove() {
        this.groupsManaged = null;
    }
}
