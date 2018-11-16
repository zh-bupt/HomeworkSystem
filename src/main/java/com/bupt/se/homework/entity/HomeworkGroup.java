package com.bupt.se.homework.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "homework_group")
public class HomeworkGroup implements Serializable {
    private Homework homework;
    private Group group;
    private HomeworkGroupPK pk;
    private Date submissionTime;
    private int score;
    private String comment;
    private String fileDir;

    public HomeworkGroup() {
    }

    public HomeworkGroup(Homework homework, Group group) {
        this.homework = homework;
        this.group = group;
        this.pk = new HomeworkGroupPK(homework.getHomeworkId(), group.getGroupId());
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
    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
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
    public int getScore() {
        return score;
    }

    public void setScore(int score) {
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
