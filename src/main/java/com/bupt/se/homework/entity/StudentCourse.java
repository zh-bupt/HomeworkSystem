package com.bupt.se.homework.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "student_course", schema = "homeworksystem", catalog = "")
@IdClass(StudentCoursePK.class)
public class StudentCourse {
    private String studentId;
    private int courseId;
    private int grade;

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    @Id
    @Column(name = "STUDENT_ID")
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    @Id
    @Column(name = "COURSE_ID")
    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
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
        StudentCourse that = (StudentCourse) o;
        return courseId == that.courseId &&
                grade == that.grade &&
                Objects.equals(studentId, that.studentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, courseId, grade);
    }
}
