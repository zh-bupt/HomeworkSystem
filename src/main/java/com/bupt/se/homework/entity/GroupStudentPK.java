package com.bupt.se.homework.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class GroupStudentPK implements Serializable {
    private String groupId;
    private String studentId;

    public GroupStudentPK() {
    }

    public GroupStudentPK(String groupId, String studentId) {
        this.groupId = groupId;
        this.studentId = studentId;
    }

    @Column(length = 40)
    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    @Column(length = 10)
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GroupStudentPK that = (GroupStudentPK) o;
        return Objects.equals(groupId, that.groupId) &&
                Objects.equals(studentId, that.studentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(groupId, studentId);
    }

    @Override
    public String toString() {
        return "GroupStudentPK{" +
                "groupId='" + groupId + '\'' +
                ", studentId='" + studentId + '\'' +
                '}';
    }
}
