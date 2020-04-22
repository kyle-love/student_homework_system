package org.example.javaee.springMVC.daolmpl;

import org.example.javaee.springMVC.dao.homeworkDao;
import org.example.javaee.springMVC.model.Homework;
import org.example.javaee.springMVC.model.Student;
import org.example.javaee.springMVC.util.ConnectionUtil;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.List;
@Component
public class homeworkDaoImpl implements homeworkDao {
Connection connection = ConnectionUtil.getConnection();
    @Override
    public boolean addHomework(String homework_id, String homework_title) {
        return false;
    }
        @Override
    public List<Homework> getAllHomework() {
        return null;
    }
}
