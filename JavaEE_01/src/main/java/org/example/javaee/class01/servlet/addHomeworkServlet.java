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

@WebServlet("/addHomeworkServlet")
public class addHomeworkServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req == null){
            System.out.println("none data");                                    //判断是否为空
        }else {
            req.setCharacterEncoding("utf-8");
            resp.setContentType("text/html;charset=utf-8");

            String homework_id = req.getParameter("homework_id");
            String homework_title = req.getParameter("homework_title");

            long homework_id_long = Long.valueOf(homework_id);


            Homework homework = new Homework(homework_id_long, homework_title);

            studentHomeworkJDBC.addHomework(homework);

            List<Homework> list = studentHomeworkJDBC.selectAllHomework();
            req.setAttribute("list", list);
            req.getRequestDispatcher("showAllHomework.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
