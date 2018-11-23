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
    private Integer num = 0;
    private String name;
    private Double groupScore = 0.;
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
    @GenericGenerator(name = "groupId", strategy = "assigned")
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
    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
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
    @Column(columnDefinition = "FLOAT(3,2)")
    public Double getGroupScore() {
        return groupScore;
    }

    public void setGroupScore(Double groupScore) {
        this.groupScore = groupScore;
    }


}
