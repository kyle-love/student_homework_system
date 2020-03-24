package org.example.javaee.class01.servlet;

import org.example.javaee.class01.jdbc.studentHomeworkJDBC;
import org.example.javaee.class01.model.Homework;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/showAllHomeworkServlet")
public class showAllHomeworkServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Homework> list = studentHomeworkJDBC.selectAllHomework();
        req.setAttribute("list",list);
        req.getRequestDispatcher("showAllHomework.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
