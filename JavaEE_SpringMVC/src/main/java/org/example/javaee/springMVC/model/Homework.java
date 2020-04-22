package org.example.javaee.springMVC.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Homework {
    private Long id;
    private String homeworkTitle;
    private String homeworkContent;
    private java.util.Date createTime;
    private java.util.Date updateTime;

    public Homework(){

    }

    public Homework(long homework_id, String homework_title) {

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");                  //设置日期格式

        java.util.Date date = new java.util.Date();
        //System.out.println(df.format(date));
        Date creat_time = new Date(date.getTime());                                //uilt.Date
        this.createTime = creat_time;
        this.id = homework_id;
        this.homeworkTitle = homework_title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHomeworkTitle() {
        return homeworkTitle;
    }

    public void setHomeworkTitle(String homeworkTitle) {
        this.homeworkTitle = homeworkTitle;
    }

    public String getHomeworkContent() {
        return homeworkContent;
    }

    public void setHomeworkContent(String homeworkContent) {
        this.homeworkContent = homeworkContent;
    }

    public java.util.Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(java.util.Date createTime) {
        this.createTime = createTime;
    }

    public java.util.Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(java.util.Date updateTime) {
        this.updateTime = updateTime;
    }
}
