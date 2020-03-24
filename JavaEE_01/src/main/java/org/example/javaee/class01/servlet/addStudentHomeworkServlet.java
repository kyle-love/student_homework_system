package org.example.javaee.class01.servlet;

import org.example.javaee.class01.jdbc.studentHomeworkJDBC;
import org.example.javaee.class01.model.StudentHomework;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addStudentHomeworkServlet")
public class addStudentHomeworkServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req == null){
            System.out.println("none data");                                    //判断是否为空
        }else{
            req.setCharacterEncoding("utf-8");
            resp.setContentType("text/html;charset=utf-8");
            String id = req.getParameter("sh_id");
            String student_id = req.getParameter("student_id");             //根据传入的req来获取学生id
            String homework_id = req.getParameter("homework_id");           //根据传入的req来获取作业id
            String homework_title =req.getParameter("homework_title");      //获取作业标题
            String homework_content =req.getParameter("homework_content");  //获取学生写的作业内容

            //转变数据类型，方便存入对象中
            long id_long = Long.valueOf(id);
            long homework_id_long = Long.valueOf(homework_id);
            long student_id_long = Long.valueOf(student_id);

            //实例化一个对象，等一下将对象存入数据库中
            StudentHomework sh = new StudentHomework(id_long,student_id_long,homework_id_long,homework_title,homework_content);

            //将对象存入数据库
            studentHomeworkJDBC.addStudentHomework(sh);

            //跳转到学生操作页面
            req.getRequestDispatcher("studentOperation.jsp").forward(req,resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
