package org.example.javaee.class01.jdbc;

import java.sql.*;

import static java.sql.DriverManager.getConnection;

public class TestJDBC {

    public static String getMysql(){
        String url = "jdbc:mysql://127.0.0.1:3306/warehouse?serverTimezone=UTC";
        String driverName = "com.mysql.cj.jdbc.Driver";
        String sqlString = "SELECT * FROM warehouse limit 2";
        try {
            // 加载驱动
            Class.forName(driverName);

            // 创建连接
            Connection connection = DriverManager.getConnection(url,"root","123456");

            // 通过链接获取statement
            Statement statement = connection.createStatement();

            // statement 做一些增删改查
            ResultSet resultSet = statement.executeQuery(sqlString);


            // 获取执行结果
            while(resultSet.next()){
                System.out.println(resultSet.getLong(1));
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return  null;
    }

    public static void main(String[] args){
        getMysql();
    }
}
