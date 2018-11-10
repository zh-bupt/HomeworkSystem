package com.bupt.se.homework.entity;

import javax.persistence.Entity;

@Entity
public class Group {

    private int groupId;
    private int courseId;
    private int capacity;
    private String name;
    private String leaderId;
    private double groupScore;

    public double getGroupScore() {
        return groupScore;
    }

    public void setGroupScore(double groupScore) {
        this.groupScore = groupScore;
    }
    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLeaderId() {
        return leaderId;
    }

    public void setLeaderId(String leaderId) {
        this.leaderId = leaderId;
    }
}
