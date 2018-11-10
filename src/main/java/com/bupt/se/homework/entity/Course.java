package com.bupt.se.homework.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
import java.util.Objects;

@Entity
public class Course
{
    private int courseId;
    private String courseName;
    private String teacherId;
    private int capacity;
    private Date createTime;
    private int groupCapacity;
    private String groupPrefix;


    @Id
    @Column(name = "COURSE_ID")
    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    @Basic
    @Column(name = "COURSE_NAME", length = 50)
    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Basic
    @Column(name = "TEACHER_ID")
    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    @Basic
    @Column(name = "CAPACITY")
    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Basic
    @Column(name = "CREATE_TIME")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "GROUP_CAPACITY")
    public int getGroupCapacity() {
        return groupCapacity;
    }

    public void setGroupCapacity(int groupCapacity) {
        this.groupCapacity = groupCapacity;
    }

    @Basic
    @Column(name = "GROUP_PREFIX")
    public String getGroupPrefix() {
        return groupPrefix;
    }

    public void setGroupPrefix(String groupPrefix) {
        this.groupPrefix = groupPrefix;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return courseId == course.courseId &&
                capacity == course.capacity &&
                Objects.equals(courseName, course.courseName) &&
                Objects.equals(teacherId, course.teacherId) &&
                Objects.equals(createTime, course.createTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseId, courseName, teacherId, capacity, createTime);
    }
}
