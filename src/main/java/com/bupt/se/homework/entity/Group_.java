package com.bupt.se.homework.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "group_")
public class Group_ extends AbstractEntity {
    private String groupId;
    private Course course;
    private int num;
    private String name;
    private double groupScore;
    private Student leader;
    private Set<GroupStudent> groupStudentSet = new HashSet<>();
    private Set<HomeworkGroup> homeworkGroups = new HashSet<>();

    public Group_() {
    }

    @OneToMany(mappedBy = "group_", cascade = {CascadeType.ALL, CascadeType.REMOVE})
    public Set<GroupStudent> getGroupStudentSet() {
        return groupStudentSet;
    }

    public void setGroupStudentSet(Set<GroupStudent> groupStudentSet) {
        this.groupStudentSet = groupStudentSet;
    }

    @OneToMany(mappedBy = "group_", cascade = {CascadeType.ALL, CascadeType.REMOVE}, fetch = FetchType.LAZY)
    public Set<HomeworkGroup> getHomeworkGroups() {
        return homeworkGroups;
    }

    public void setHomeworkGroups(Set<HomeworkGroup> homeworkGroups) {
        this.homeworkGroups = homeworkGroups;
    }

    @Id
    @GeneratedValue(generator = "groupId")
    @GenericGenerator(name = "groupId", strategy = "increment")
    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    @ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinColumn(name = "courseId")
    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Basic
    @Column(length = 4)
    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num= num;
    }

    @Basic
    @Column(length = 20)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinColumn(name = "leaderId", referencedColumnName = "studentId")
    public Student getLeader() {
        return leader;
    }

    public void setLeader(Student leader) {
        this.leader = leader;
    }

    @Basic
    @Column
    public double getGroupScore() {
        return groupScore;
    }

    public void setGroupScore(double groupScore) {
        this.groupScore = groupScore;
    }


}
