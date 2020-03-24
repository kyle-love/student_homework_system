package org.example.javaee.class01.servlet;

import org.example.javaee.class01.jdbc.studentHomeworkJDBC;
import org.example.javaee.class01.model.StudentHomework;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/list")
public class StudentHomeworkServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<StudentHomework> list = studentHomeworkJDBC.selectAll();
        req.setAttribute("list",list);
        req.getRequestDispatcher("showAllStudentHomework.jsp").forward(req,resp);
    }
}
