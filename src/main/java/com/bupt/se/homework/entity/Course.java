package com.bupt.se.homework.entity;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "course")
public class Course extends AbstractEntity {
    private String courseId;
    private String courseName;
//    private Integer capacity;
    private Integer minStudentNum = 0;
    private Integer maxStudentNum = 1000;
    private Date createTime;
    private Integer groupCapacity = 100;
    private String groupPrefix = "";
    private Teacher teacher;
    private Set<Homework> homework = new HashSet<>();
    private Set<StudentCourse> studentCourses = new HashSet<>();
    private Set<Group_> groups = new HashSet<>();

    public Course() {
    }

    @OneToMany(mappedBy = "course", cascade = {CascadeType.ALL, CascadeType.REMOVE}, fetch = FetchType.LAZY)
    public Set<Homework> getHomework() {
        return homework;
    }

    public void setHomework(Set<Homework> homework) {
        this.homework = homework;
    }

    @OneToMany(mappedBy = "course", cascade = {CascadeType.ALL, CascadeType.REMOVE}, fetch = FetchType.LAZY)
    public Set<StudentCourse> getStudentCourses() {
        return studentCourses;
    }

    public void setStudentCourses(Set<StudentCourse> studentCourses) {
        this.studentCourses = studentCourses;
    }

    @OneToMany(cascade = {CascadeType.ALL, CascadeType.REMOVE}, fetch = FetchType.LAZY)
    @JoinColumn(name = "courseId")
    public Set<Group_> getGroups() {
        return groups;
    }

    public void setGroups(Set<Group_> groups) {
        this.groups = groups;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "teacherId")
    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Id
    @Column(length = 10)
    @GeneratedValue(generator = "courseId")
    @GenericGenerator(name = "courseId", strategy = "assigned")
    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    @Basic
    @Column(length = 50)
    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Basic
    public Integer getMaxStudentNum() {
        return maxStudentNum;
    }

    public void setMaxStudentNum(Integer maxStudentNum) {
        this.maxStudentNum = maxStudentNum;
    }

    @Basic
    public Integer getMinStudentNum() {
        return minStudentNum;
    }

    public void setMinStudentNum(Integer minStudentNum) {
        this.minStudentNum = minStudentNum;
    }

//    @Basic()
//    @Column(length = 3)
//    public Integer getCapacity() {
//        return capacity;
//    }
//
//    public void setCapacity(Integer capacity) {
//        this.capacity = capacity;
//    }

    @Basic
    @Column(columnDefinition = "DATE")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column()
    public Integer getGroupCapacity() {
        return groupCapacity;
    }

    public void setGroupCapacity(Integer groupCapacity) {
        this.groupCapacity = groupCapacity;
    }

    @Basic
    @Column(length = 10)
    public String getGroupPrefix() {
        return groupPrefix;
    }

    public void setGroupPrefix(String groupPrefix) {
        this.groupPrefix = groupPrefix;
    }
}
