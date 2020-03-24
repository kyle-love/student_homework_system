package org.example.javaee.class01.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StudentHomework {

    public  StudentHomework(){

    }
    public StudentHomework(long sh_id,long student_id,long homework_id, String homeworkTitle,String homeworkContent){
        this.id = sh_id;
        this.studentId = student_id;
        this.homeworkId = homework_id;
        this.homeworkTitle = homeworkTitle;
        this.homeworkContent = homeworkContent;
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        Date date = new Date();
        java.sql.Date creat_time = new java.sql.Date(date.getTime());                                //uilt.Date
        this.createTime = creat_time;
        this.updateTime = creat_time;
    }
    private Long id;
    private Long  studentId;
    private Long  homeworkId;
    private String homeworkTitle;
    private String homeworkContent;
    private Date createTime;
    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getHomeworkId() {
        return homeworkId;
    }

    public void setHomeworkId(Long homeworkId) {
        this.homeworkId = homeworkId;
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
