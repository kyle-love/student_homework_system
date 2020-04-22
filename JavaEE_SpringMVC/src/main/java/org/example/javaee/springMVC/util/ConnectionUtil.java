package org.example.javaee.springMVC.util;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionUtil {
    private static Connection connection;

    private ConnectionUtil(){ }

    synchronized public static Connection getConnection() {
        if(connection == null) {
            try {
                connection = databasePool.getHikariDataSource().getConnection();
            } catch (SQLException e) {
                e.printStackTrace();
                try {
                    connection.close();
                } catch (SQLException e1) {
                    e.printStackTrace();
                }
            }
        }

        return connection;
    }
}
