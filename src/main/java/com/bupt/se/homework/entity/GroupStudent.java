package com.bupt.se.homework.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "group_student")
public class GroupStudent implements Serializable {

    private GroupStudentPK pk;
    private Group_ group_;
    private Student student;
    private int contribution;

    public GroupStudent() {
    }

    public GroupStudent(Group_ group_, Student student) {
        this.group_ = group_;
        this.student = student;
        this.pk = new GroupStudentPK(group_.getGroupId(), student.getStudentId());
    }

    @EmbeddedId
    public GroupStudentPK getPk() {
        return pk;
    }

    public void setPk(GroupStudentPK pk) {
        this.pk = pk;
    }

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "studentId", insertable = false, updatable = false)
    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
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
    @Column(length = 3)
    public int getContribution() {
        return contribution;
    }

    public void setContribution(int contribution) {
        this.contribution = contribution;
    }
}
