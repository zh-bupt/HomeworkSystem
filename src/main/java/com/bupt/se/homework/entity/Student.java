package com.bupt.se.homework.entity;

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
    private Set<Course> courses = new HashSet<>();
    private Set<Group> groupsManaged = new HashSet<>();
    private Set<Group> groupsJoined = new HashSet<>();

    public Student() {
    }

    public Student(String studentId, String studentName, String password) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.password = password;
    }

    @ManyToMany(cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinTable(
            name = "student_course",
            joinColumns = {@JoinColumn(name = "studentId")},
            inverseJoinColumns = {@JoinColumn(name = "courseId")}
    )
    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    @ManyToMany(mappedBy = "members", fetch = FetchType.LAZY)
    public Set<Group> getGroupsJoined() {
        return groupsJoined;
    }

    public void setGroupsJoined(Set<Group> groupsJoined) {
        this.groupsJoined = groupsJoined;
    }

    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinColumn(name = "leaderId")
    public Set<Group> getGroupsManaged() {
        return groupsManaged;
    }

    public void setGroupsManaged(Set<Group> groupsManaged) {
        this.groupsManaged = groupsManaged;
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
