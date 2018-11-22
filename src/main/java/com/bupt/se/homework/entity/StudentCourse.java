package com.bupt.se.homework.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "student_course")
public class StudentCourse extends AbstractEntity {
    private StudentCoursePK pk;
    private Student student;
    private Course course;
    private int grade = 0;

    public StudentCourse() {
    }

    public StudentCourse(Student student, Course course) {
        this.student = student;
        this.course = course;
        this.pk = new StudentCoursePK(student.getStudentId(), course.getCourseId());
    }

    @EmbeddedId
    public StudentCoursePK getPk() {
        return pk;
    }

    public void setPk(StudentCoursePK pk) {
        this.pk = pk;
    }

    @ManyToOne
    @JoinColumn(name = "courseId", updatable = false, insertable = false)
    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @ManyToOne
    @JoinColumn(name = "studentId", updatable = false, insertable = false)
    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Basic
    @Column(length = 3)
    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
