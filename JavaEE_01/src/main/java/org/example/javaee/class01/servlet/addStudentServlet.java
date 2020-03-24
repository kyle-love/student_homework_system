package org.example.javaee.class01.servlet;

import org.example.javaee.class01.jdbc.studentHomeworkJDBC;
import org.example.javaee.class01.model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/addStudentServlet")
public class addStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req == null){
            System.out.println("none data");                                    //判断是否为空
        }else {
            req.setCharacterEncoding("utf-8");
            resp.setContentType("text/html;charset=utf-8");

//            System.out.println(req);
//            System.out.println(req.getParameter("id"));
//            System.out.println(req.getParameter("name"));
            String student_id = req.getParameter("id");
            String student_name = req.getParameter("name");

            long student_id_long = Long.valueOf(student_id);

//        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
//        String dateString = df.format(new Date());// new Date()为获取当前系统时间，也可使用当前时间戳
//        ParsePosition pos = new ParsePosition(8);
//        Date createTime = df.parse(dateString, pos);
//        Date updateTime = createTime;

            Student student = new Student(student_id_long, student_name);
            studentHomeworkJDBC.addStudent(student);

            List<Student> list = studentHomeworkJDBC.selectAllStudent();
            req.setAttribute("list", list);
            req.getRequestDispatcher("showAllStudent.jsp").forward(req, resp);
        }

    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);

    }
}
