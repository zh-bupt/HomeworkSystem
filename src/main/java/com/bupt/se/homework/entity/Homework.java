package com.bupt.se.homework.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "homework")
public class Homework implements Serializable {

    private int homeworkId;
    private Course course;
    private String content;
    private Date releaseTime;
    private Date deadline;
    private Integer percentage = 0;
    private Set<HomeworkGroup> homeworkGroups = new HashSet<>();
    private Set<StudentHomework> studentHomeworkSet = new HashSet<>();

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
    public Set<HomeworkGroup> getHomeworkGroups() {
        return homeworkGroups;
    }

    public void setHomeworkGroups(Set<HomeworkGroup> homeworkGroups) {
        this.homeworkGroups = homeworkGroups;
    }

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REMOVE}, fetch = FetchType.LAZY)
    @JoinColumn(name = "courseId")
    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @OneToMany(mappedBy = "homework", cascade = {CascadeType.ALL, CascadeType.REMOVE}, fetch = FetchType.LAZY)
    public Set<StudentHomework> getStudentHomeworkSet() {
        return studentHomeworkSet;
    }

    public void setStudentHomeworkSet(Set<StudentHomework> studentHomeworkSet) {
        this.studentHomeworkSet = studentHomeworkSet;
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
    @Column(columnDefinition = "DATE")
    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    @Basic
    @Column(columnDefinition = "DATE")
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
