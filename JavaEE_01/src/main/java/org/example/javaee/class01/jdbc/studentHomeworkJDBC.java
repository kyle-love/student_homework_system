package org.example.javaee.class01.jdbc;

import org.example.javaee.class01.model.Homework;
import org.example.javaee.class01.model.Student;
import org.example.javaee.class01.model.StudentHomework;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class studentHomeworkJDBC {
    public static void main(String[] args) {
//        List<StudentHomework> list = selectAll();
//
//        for(StudentHomework sh:list){
//            System.out.println(sh.getHomeworkContent());
//        }
        //addStudentHomework();
    }

    public static void addStudent(Student student){
        String url = "jdbc:mysql://127.0.0.1:3306/school?serverTimezone=UTC";
        String driverName = "com.mysql.cj.jdbc.Driver";

        try {
            // 加载驱动
            Class.forName(driverName);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try(Connection connection = DatabasePool.getHikariDataSource().getConnection()){  // 创建连接
            try(Statement statement = connection.createStatement()){                                    // 通过链接获取statement
                String sql = "insert into s_student (id,name,create_time,update_time) values(? ,?,?,?)";
                PreparedStatement ps = connection.prepareStatement(sql);

                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
                java.util.Date date = new java.util.Date();
                // 为sql语句中第一个问号赋值
                ps.setLong(1,student.getId());
                // 为sql语句中第二个问号赋值
                ps.setString(2, student.getName());
                // 为sql语句中第三个问号赋值
                ps.setTimestamp(3, Timestamp.valueOf(df.format(student.getCreateTime())));
                // 为sql语句中第四个问号赋值
                ps.setTimestamp(4, Timestamp.valueOf(df.format(date.getTime())));
                // 执行sql语句
                ps.executeUpdate();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void addHomework(Homework homework){
        String url = "jdbc:mysql://127.0.0.1:3306/school?serverTimezone=UTC";
        String driverName = "com.mysql.cj.jdbc.Driver";

        try {
            // 加载驱动
            Class.forName(driverName);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try(Connection connection = DatabasePool.getHikariDataSource().getConnection()){  // 创建连接
            try(Statement statement = connection.createStatement()){                                    // 通过链接获取statement
                String sql = "insert into s_homework (id,title,content,create_time,update_time) values(?,?,?,?,?)";
                PreparedStatement ps = connection.prepareStatement(sql);

                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
                java.util.Date date = new java.util.Date();
                // 为sql语句中第一个问号赋值
                ps.setLong(1,homework.getId());
                // 为sql语句中第二个问号赋值
                ps.setString(2, homework.getHomeworkTitle());
                // 为sql语句中第三个问号赋值
                ps.setString(3, null);
                // 为sql语句中第四个问号赋值
                ps.setTimestamp(4, Timestamp.valueOf(df.format(homework.getCreateTime())));
                // 为sql语句中第五个问号赋值
                ps.setTimestamp(5, Timestamp.valueOf(df.format(date.getTime())));
                // 执行sql语句
                ps.executeUpdate();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void addStudentHomework (StudentHomework studentHomework){
        String url = "jdbc:mysql://127.0.0.1:3306/school?serverTimezone=UTC";
        String driverName = "com.mysql.cj.jdbc.Driver";

        try {
            // 加载驱动
            Class.forName(driverName);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        List<StudentHomework> list = new ArrayList<>();
        try(Connection connection = DatabasePool.getHikariDataSource().getConnection()){  // 创建连接
            try(Statement statement = connection.createStatement()){                                    // 通过链接获取statement
                    String sql = "insert into s_student_homework (id,student_id,homework_id,homework_title,homework_content,create_time,update_time) values(?,?,?,?,?,?,?)";
                    PreparedStatement ps = connection.prepareStatement(sql);


                    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
                    java.util.Date date = new java.util.Date();
                    // 为sql语句中第一个问号赋值
                    ps.setLong(1,studentHomework.getId());
                    ps.setLong(2,studentHomework.getStudentId());
                    ps.setLong(3,studentHomework.getHomeworkId());
                    ps.setString(4, studentHomework.getHomeworkTitle());
                    ps.setString(5, studentHomework.getHomeworkContent());
                    ps.setTimestamp(6, Timestamp.valueOf(df.format(studentHomework.getCreateTime())));
                    // 为sql语句中第五个问号赋值
                    ps.setTimestamp(7, Timestamp.valueOf(df.format(date.getTime())));
                    // 执行sql语句
                    ps.executeUpdate();
                } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Homework> selectAllHomework(){
        String url = "jdbc:mysql://127.0.0.1:3306/school?serverTimezone=UTC";
        String driverName = "com.mysql.cj.jdbc.Driver";
        String sqlString = "SELECT * FROM s_homework ";

        try {
            // 加载驱动
            Class.forName(driverName);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        List<Homework> list = new ArrayList<>();
        try(Connection connection = DatabasePool.getHikariDataSource().getConnection()){  // 创建连接
            try(Statement statement = connection.createStatement()){                                    // 通过链接获取statement
                try(ResultSet resultSet = statement.executeQuery(sqlString)){                           // 获取执行结果
                    while(resultSet.next()){

                        Homework homework = new Homework();
                        homework.setId(resultSet.getLong("id"));
                        homework.setHomeworkTitle(resultSet.getString("title"));
                        homework.setHomeworkContent(resultSet.getString("content"));
                        homework.setCreateTime(resultSet.getTimestamp("create_time"));
                        homework.setUpdateTime(resultSet.getTimestamp("update_time"));
                        list.add(homework);

                        System.out.println(resultSet.getLong(1));
                    }
                }
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }


    public static List<Student> selectAllStudent(){
        String url = "jdbc:mysql://127.0.0.1:3306/school?serverTimezone=UTC";
        String driverName = "com.mysql.cj.jdbc.Driver";
        String sqlString = "SELECT * FROM s_student ";

        try {
            // 加载驱动
            Class.forName(driverName);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        List<Student> list = new ArrayList<>();
        try(Connection connection = DatabasePool.getHikariDataSource().getConnection()){  // 创建连接
            try(Statement statement = connection.createStatement()){                                    // 通过链接获取statement
                try(ResultSet resultSet = statement.executeQuery(sqlString)){                           // 获取执行结果
                    while(resultSet.next()){

                        Student student = new Student();
                        student.setId(resultSet.getLong("id"));
                        student.setName(resultSet.getString("name"));
                        student.setCreateTime(resultSet.getTimestamp("create_time"));
                        student.setUpdateTime(resultSet.getTimestamp("update_time"));
                        list.add(student);

                        System.out.println(resultSet.getLong(1));
                    }
                }
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static List<StudentHomework> selectAll(){

        String url = "jdbc:mysql://127.0.0.1:3306/school?serverTimezone=UTC";
        String driverName = "com.mysql.cj.jdbc.Driver";
        String sqlString = "SELECT * FROM s_student_homework ";

        try {
            // 加载驱动
            Class.forName(driverName);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        List<StudentHomework> list = new ArrayList<>();
        try(Connection connection = DatabasePool.getHikariDataSource().getConnection()){  // 创建连接
            try(Statement statement = connection.createStatement()){                                    // 通过链接获取statement
                try(ResultSet resultSet = statement.executeQuery(sqlString)){                           // 获取执行结果
                    while(resultSet.next()){
                        StudentHomework sh = new StudentHomework();
                        sh.setId(resultSet.getLong("id"));
                        sh.setStudentId(resultSet.getLong("student_id"));
                        sh.setHomeworkId(resultSet.getLong("homework_id"));
                        sh.setHomeworkTitle(resultSet.getString("homework_title"));
                        sh.setHomeworkContent(resultSet.getString("homework_content"));
                        sh.setCreateTime(resultSet.getTimestamp("create_time"));
                        list.add(sh);
                        System.out.println(resultSet.getLong(1));
                    }
                }
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
