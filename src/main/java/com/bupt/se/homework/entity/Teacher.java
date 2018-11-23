package com.bupt.se.homework.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "teacher")
public class Teacher extends AbstractEntity {

    private String teacherId;
    private String teacherName;
    private String sex;
    private String profession;
    private String telephone;
    private String email;
    private String password;
    private Set<Course> courses = new HashSet<>();

    public Teacher() {
    }

    @Basic
    @Column(length = 40)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Id
    @Column(length = 10)
    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    @Basic
    @Column(length = 20)
    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    @Basic
    @OneToMany(cascade = {CascadeType.ALL, CascadeType.REMOVE}, fetch = FetchType.LAZY)
    @JoinColumn(name = "teacherId")
    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    @Basic
    @Column(length = 2)
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Basic
    @Column(length = 40)
    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    @Basic
    @Column(length = 20)
    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Basic
    @Column(length = 40)
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
