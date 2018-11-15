package com.bupt.se.homework.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

/**
 * @description: pk of StudentHomework entity
 * @author: zh
 * @create: 2018-11-15 14:37
 **/
@Embeddable
public class StudentHomeworkPK implements Serializable {
    private int homeworkId;
    private String studentId;

    public StudentHomeworkPK() {
    }

    public StudentHomeworkPK(int homeworkId, String studentId) {
        this.homeworkId = homeworkId;
        this.studentId = studentId;
    }

    public void setHomeworkId(int homeworkId) {
        this.homeworkId = homeworkId;
    }

    public int getHomeworkId() {
        return homeworkId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentId() {
        return studentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentHomeworkPK that = (StudentHomeworkPK) o;
        return homeworkId == that.homeworkId &&
                Objects.equals(studentId, that.studentId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(homeworkId, studentId);
    }
}
