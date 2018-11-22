package com.bupt.se.homework.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "student")
public class Student implements Serializable {

    private String studentId;
    private String studentName;
    private String classId;
    private String sex;
    private Date entranceDate;
    private String password;
    private String email;
    private Set<StudentCourse> studentCourses = new HashSet<>();
    private Set<Group_> groupsManaged = new HashSet<>();
    private Set<Group_> groupsJoined = new HashSet<>();
    private Set<GroupStudent> groupStudentSet = new HashSet<>();
    private Set<StudentHomework> studentHomeworkSet = new HashSet<>();

    public Student() {
    }

    public Student(String studentId, String studentName, String password) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.password = password;
    }

    @OneToMany(mappedBy = "student", cascade = {CascadeType.ALL, CascadeType.REMOVE}, fetch = FetchType.LAZY)
    public Set<StudentCourse> getStudentCourses() {
        return studentCourses;
    }

    public void setStudentCourses(Set<StudentCourse> studentCourses) {
        this.studentCourses = studentCourses;
    }

    @OneToMany(mappedBy = "student", cascade = {CascadeType.ALL, CascadeType.REMOVE})
    public Set<GroupStudent> getGroupStudentSet() {
        return groupStudentSet;
    }

    public void setGroupStudentSet(Set<GroupStudent> groupStudentSet) {
        this.groupStudentSet = groupStudentSet;
    }

    @ManyToMany(mappedBy = "members", cascade = {CascadeType.ALL},fetch = FetchType.LAZY)
    public Set<Group_> getGroupsJoined() {
        return groupsJoined;
    }

    public void setGroupsJoined(Set<Group_> groupsJoined) {
        this.groupsJoined = groupsJoined;
    }

    @OneToMany(cascade = {CascadeType.ALL, CascadeType.DETACH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "leaderId")
    public Set<Group_> getGroupsManaged() {
        return groupsManaged;
    }

    public void setGroupsManaged(Set<Group_> groupsManaged) {
        this.groupsManaged = groupsManaged;
    }

    @OneToMany(mappedBy = "student", cascade = {CascadeType.ALL, CascadeType.REMOVE}, fetch = FetchType.LAZY)
    public Set<StudentHomework> getStudentHomeworkSet() {
        return studentHomeworkSet;
    }

    public void setStudentHomeworkSet(Set<StudentHomework> studentHomeworkSet) {
        this.studentHomeworkSet = studentHomeworkSet;
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
}
