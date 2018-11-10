package com.bupt.se.homework.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

@Entity
public class Homework {

    private int homeworkId;
    private int courseId;
    private String content;
    private Date releaseTime;
    private Date deadline;
    private Timestamp releasetime;

    public void setDeadline(Timestamp deadline) {
        this.deadline = deadline;
    }

    @Id
    @Column(name = "HOMEWORK_ID")
    public int getHomeworkId() {
        return homeworkId;
    }

    public void setHomeworkId(int homeworkId) {
        this.homeworkId = homeworkId;
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
    @Column(name = "CONTENT")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
    }

    @Basic
    @Column(name = "DEADLINE")
    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    @Basic
    @Column(name = "RELEASETIME")
    public Timestamp getReleasetime() {
        return releasetime;
    }

    public void setReleasetime(Timestamp releasetime) {
        this.releasetime = releasetime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Homework homework = (Homework) o;
        return homeworkId == homework.homeworkId &&
                courseId == homework.courseId &&
                Objects.equals(content, homework.content) &&
                Objects.equals(deadline, homework.deadline) &&
                Objects.equals(releasetime, homework.releasetime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(homeworkId, courseId, content, releasetime, deadline);
    }
}
