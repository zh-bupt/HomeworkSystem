package com.bupt.se.homework.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "homework_group", schema = "homeworksystem", catalog = "")
@IdClass(HomeworkGroupPK.class)
public class HomeworkGroup {

    private int groupId;
    private int homeworkId;
    private Date submissionTime;
    private int score;
    private String comment;
    private String fileDir;
    private String filedir;

    public void setSubmissionTime(Timestamp submissionTime) {
        this.submissionTime = submissionTime;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getFileDir() {
        return fileDir;
    }

    public void setFileDir(String fileDir) {
        this.fileDir = fileDir;
    }

    @Id
    @Column(name = "GROUP_ID")
    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
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
    @Column(name = "SUBMISSION_TIME")
    public Date getSubmissionTime() {
        return submissionTime;
    }

    public void setSubmissionTime(Date submissionTime) {
        this.submissionTime = submissionTime;
    }

    @Basic
    @Column(name = "SCORE")
    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Basic
    @Column(name = "COMMENT")
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Basic
    @Column(name = "FILEDIR")
    public String getFiledir() {
        return filedir;
    }

    public void setFiledir(String filedir) {
        this.filedir = filedir;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HomeworkGroup that = (HomeworkGroup) o;
        return groupId == that.groupId &&
                homeworkId == that.homeworkId &&
                score == that.score &&
                Objects.equals(submissionTime, that.submissionTime) &&
                Objects.equals(comment, that.comment) &&
                Objects.equals(filedir, that.filedir);
    }

    @Override
    public int hashCode() {
        return Objects.hash(groupId, homeworkId, submissionTime, score, comment, filedir);
    }
}
