package org.example.javaee.springMVC.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Student {

    private long id;
    private String name;
    private Date createTime;
    private Date updateTime;

    public Student(){

    }

    public Student(long student_id_long, String student_name) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        Date date = new Date();
        //System.out.println(df.format(date));

//        java.sql.Date creat_time = new java.sql.Date(date.getTime());                                //uilt.Date
        this.id = student_id_long;
        this.name = student_name;
        //Timestamp creat_time = new Timestamp(utilDate.getTime());
        this.createTime = date;
        this.updateTime = date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
