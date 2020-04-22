package org.example.javaee.springMVC.daolmpl;

import org.example.javaee.springMVC.dao.studentDao;
import org.example.javaee.springMVC.model.Student;
import org.example.javaee.springMVC.util.ConnectionUtil;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.List;
@Component
public class studentDaoImpl implements studentDao {
    Connection connection = ConnectionUtil.getConnection();
    @Override
    public boolean addStudent(String student_name, String student_id) {

        try (Statement statement = connection.createStatement()) {                                    // 通过链接获取statement
            String sql = "insert into s_student (id,name,create_time,update_time) values(? ,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);

            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
            java.util.Date date = new java.util.Date();
            // 为sql语句中第一个问号赋值
            ps.setLong(1, Long.valueOf(student_id));
            // 为sql语句中第二个问号赋值
            ps.setString(2, student_name);
            // 为sql语句中第三个问号赋值
            ps.setTimestamp(3, Timestamp.valueOf(df.format(date.getTime())));
            // 为sql语句中第四个问号赋值
            ps.setTimestamp(4, Timestamp.valueOf(df.format(date.getTime())));
            // 执行sql语句
            ps.executeUpdate();
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Student> showAllStudent() {
        return null;
    }
}
