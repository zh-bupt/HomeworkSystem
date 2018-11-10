package com.bupt.se.homework.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "group_student", schema = "homeworksystem", catalog = "")
@IdClass(GroupStudentPK.class)
public class GroupStudent {

    private int groupId;
    private String studentId;
    private int grade;

    public void setGrade(Integer grade) {
        this.grade = grade;
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
    @Column(name = "STUDENT_ID")
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    @Basic
    @Column(name = "GRADE")
    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GroupStudent that = (GroupStudent) o;
        return groupId == that.groupId &&
                grade == that.grade &&
                Objects.equals(studentId, that.studentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(groupId, studentId, grade);
    }
}
