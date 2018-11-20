package com.bupt.se.homework.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "homework_group")
public class HomeworkGroup implements Serializable {
    private Homework homework;
    private Group_ group_;
    private HomeworkGroupPK pk;
    private Date submissionTime;
    private Integer score;
    private String comment;
    private String fileDir;

    public HomeworkGroup() {
    }

    public HomeworkGroup(Homework homework, Group_ group_) {
        this.homework = homework;
        this.group_ = group_;
        this.pk = new HomeworkGroupPK(homework.getHomeworkId(), group_.getGroupId());
    }

    @EmbeddedId
    public HomeworkGroupPK getPk() {
        return pk;
    }

    public void setPk(HomeworkGroupPK pk) {
        this.pk = pk;
    }

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "homeworkId", insertable = false, updatable = false)
    public Homework getHomework() {
        return homework;
    }

    public void setHomework(Homework homework) {
        this.homework = homework;
    }

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "groupId", insertable = false, updatable = false)
    public Group_ getGroup_() {
        return group_;
    }

    public void setGroup_(Group_ group_) {
        this.group_ = group_;
    }

    @Basic
    @Column(columnDefinition = "DATE")
    public Date getSubmissionTime() {
        return submissionTime;
    }

    public void setSubmissionTime(Date submissionTime) {
        this.submissionTime = submissionTime;
    }

    @Basic
    @Column(length = 3)
    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Basic
    @Column
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Basic
    @Column
    public String getFileDir() {
        return fileDir;
    }

    public void setFileDir(String fileDir) {
        this.fileDir = fileDir;
    }
}
