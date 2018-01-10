package com.datababy.Entity;

import com.alibaba.fastjson.annotation.JSONField;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue
    private Integer id;

    private String user_name;

    private Integer grade;

    @JSONField(format = "yyyy-MM-dd HH:mm")
    private Date birth;

    private String major;

    private String college;

    @JSONField(format = "yyyy-MM-dd HH:mm")
    private Date entry_date;

    public Student() {
    }

    public Student(Integer id, String user_name, Integer grade, Date birth, String major, String college, Date entry_date) {
        this.id = id;
        this.user_name = user_name;
        this.grade = grade;
        this.birth = birth;
        this.major = major;
        this.college = college;
        this.entry_date = entry_date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public Date getEntry_date() {
        return entry_date;
    }

    public void setEntry_date(Date entry_date) {
        this.entry_date = entry_date;
    }
}