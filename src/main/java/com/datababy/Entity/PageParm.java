package com.datababy.Entity;

public class PageParm {
    private Integer id;//学生id

    private String user_name;//学生姓名

    private String major;//学生专业

    public PageParm() {
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

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
}
