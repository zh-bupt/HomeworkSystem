package com.bupt.se.homework.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "group_course", schema = "homeworksystem", catalog = "")
public class GroupCourse {
    private int groupId;
    private int courseId;
    private Integer capacity;
    private String name;
    private String leaderId;
    private Double groupScore;

    @Id
    @Column(name = "GROUP_ID")
    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    @Basic
    @Column(name = "COURSE_ID")
    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    @Basic
    @Column(name = "CAPACITY")
    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    @Basic
    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "LEADER_ID")
    public String getLeaderId() {
        return leaderId;
    }

    public void setLeaderId(String leaderId) {
        this.leaderId = leaderId;
    }

    @Basic
    @Column(name = "GROUP_SCORE")
    public Double getGroupScore() {
        return groupScore;
    }

    public void setGroupScore(Double groupScore) {
        this.groupScore = groupScore;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GroupCourse that = (GroupCourse) o;
        return groupId == that.groupId &&
                courseId == that.courseId &&
                Objects.equals(capacity, that.capacity) &&
                Objects.equals(name, that.name) &&
                Objects.equals(leaderId, that.leaderId) &&
                Objects.equals(groupScore, that.groupScore);
    }

    @Override
    public int hashCode() {
        return Objects.hash(groupId, courseId, capacity, name, leaderId, groupScore);
    }
}
