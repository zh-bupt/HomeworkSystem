package com.bupt.se.homework.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "homework")
public class Homework extends AbstractEntity {

    private int homeworkId;
    private Course course;
    private String content;
    private Date releaseTime;
    private Date deadline;
    private Integer percentage = 0;
    private List<HomeworkGroup> homeworkGroups = new ArrayList<>();
    private List<StudentHomework> studentHomeworkList = new ArrayList<StudentHomework>();

    public Homework() {
    }

    @Id
    @Column(length = 10)
    @GeneratedValue(generator = "homeworkId")
    @GenericGenerator(name = "homeworkId", strategy = "increment")
    public int getHomeworkId() {
        return homeworkId;
    }

    public void setHomeworkId(int homeworkId) {
        this.homeworkId = homeworkId;
    }

    @OneToMany(mappedBy = "homework", cascade = {CascadeType.ALL, CascadeType.REMOVE}, fetch = FetchType.LAZY)
    public List<HomeworkGroup> getHomeworkGroups() {
        return homeworkGroups;
    }

    public void setHomeworkGroups(List<HomeworkGroup> homeworkGroups) {
        this.homeworkGroups = homeworkGroups;
    }

    @ManyToOne(cascade = {CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinColumn(name = "courseId")
    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @OneToMany(mappedBy = "homework", cascade = {CascadeType.ALL, CascadeType.REMOVE}, fetch = FetchType.LAZY)
    public List<StudentHomework> getStudentHomeworkList() {
        return studentHomeworkList;
    }

    public void setStudentHomeworkList(List<StudentHomework> studentHomeworkList) {
        this.studentHomeworkList = studentHomeworkList;
    }

    @Basic
    @Column(length = 100)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(columnDefinition = "DATETIME")
    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    @Basic
    @Column(columnDefinition = "DATETIME")
    public Date getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
    }

    @Basic
    @Column(columnDefinition = "INT(3)")
    public Integer getPercentage() {
        return percentage;
    }

    public void setPercentage(Integer percentage) {
        this.percentage = percentage;
    }
}
