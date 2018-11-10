package com.bupt.se.homework.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Teacher implements Serializable {

    private String teacherId;
    private String teacherName;
    private String sex;
    private String profession;
    private String telephone;
    private String email;
    private String password;


    @Basic
    @Column(name = "PASSWORD", length = 40)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Id
    @Column(name = "TEACHER_ID", length = 10)
    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    @Basic
    @Column(name = "TEACHER_NAME", length = 20)
    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    @Basic
    @Column(name = "SEX", length = 2)
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Basic
    @Column(name = "PROFESSION", length = 40)
    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    @Basic
    @Column(name = "TELEPHONE", length = 11)
    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Basic
    @Column(name = "EMAIL", length = 40)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return Objects.equals(teacherId, teacher.teacherId) &&
                Objects.equals(teacherName, teacher.teacherName) &&
                Objects.equals(sex, teacher.sex) &&
                Objects.equals(profession, teacher.profession) &&
                Objects.equals(telephone, teacher.telephone) &&
                Objects.equals(email, teacher.email) &&
                Objects.equals(password, teacher.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(teacherId, teacherName, sex, profession, telephone, email, password);
    }
}
