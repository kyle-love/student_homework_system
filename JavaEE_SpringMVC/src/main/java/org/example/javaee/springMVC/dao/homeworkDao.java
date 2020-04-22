package org.example.javaee.springMVC.dao;

import org.example.javaee.springMVC.model.Homework;

import java.util.List;

public interface homeworkDao {
    boolean addHomework(String homework_id,String homework_title);
    List<Homework> getAllHomework();

}
