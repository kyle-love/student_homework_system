package org.example.javaee.springMVC.dao;

import org.example.javaee.springMVC.model.Student;

import java.util.List;

public interface studentDao {
    boolean addStudent (String student_name, String student_id);
    List<Student> showAllStudent();
}
