package com.datababy.Entity;

public class PageParm {
    private Integer page=0;

    private Integer size=10;

    private String parm;//全局查询条件

    private Integer id;//学生id

    private String user_name;//学生姓名

    private String major;//学生专业

    public PageParm() {
    }

    public PageParm(Integer page, Integer size, String parm, Integer id, String user_name, String major) {
        this.page = page;
        this.size = size;
        this.parm = parm;
        this.id = id;
        this.user_name = user_name;
        this.major = major;
    }

    public String getParm() {
        return parm;
    }

    public void setParm(String parm) {
        this.parm = parm;
    }

    public Integer getPage() {
        return page/size;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
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
