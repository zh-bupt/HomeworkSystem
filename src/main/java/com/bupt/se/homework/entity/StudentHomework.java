package com.bupt.se.homework.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @description: student_homework实体类
 * @author: zh
 * @create: 2018-11-15 14:36
 **/
@Entity
@Table(name = "student_homework")
public class StudentHomework extends AbstractEntity {
    private StudentHomeworkPK pk;
    private Homework homework;
    private Student student;
    private Double groupScore = 0.;
    private Integer score = 0;

    public StudentHomework() {
    }

    public StudentHomework(Homework homework, Student student) {
        this.homework = homework;
        this.student = student;
        this.pk = new StudentHomeworkPK(homework.getHomeworkId(), student.getStudentId());
    }

    @EmbeddedId
    public StudentHomeworkPK getPk() {
        return pk;
    }

    public void setPk(StudentHomeworkPK pk) {
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
    @JoinColumn(name = "homeworkId", insertable = false, updatable = false)
    public Homework getHomework() {
        return homework;
    }

    public void setHomework(Homework homework) {
        this.homework = homework;
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
    @Column(length = 3)
    public Double getGroupScore() {
        return groupScore;
    }

    public void setGroupScore(Double groupScore) {
        this.groupScore = groupScore;
    }
}
