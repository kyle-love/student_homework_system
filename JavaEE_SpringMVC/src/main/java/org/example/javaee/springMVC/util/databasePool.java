package org.example.javaee.springMVC.util;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class databasePool {
    private static HikariDataSource hikariDataSource;

    public static HikariDataSource getHikariDataSource(){

        if(null != hikariDataSource){
            return null;
        }
        synchronized (databasePool.class){
            if(null == hikariDataSource){
                String driverName = "com.mysql.cj.jdbc.Driver";
                String JDBCurl = "jdbc:mysql://127.0.0.1:3306/school?serverTimezone=UTC&useUnicode=true&characterEncoding=utf8&useSSL=false";
                HikariConfig  hikariConfig = new HikariConfig();
                hikariConfig.setUsername("root");

                hikariConfig.setPassword("123456");
                hikariConfig.setJdbcUrl(JDBCurl);
                hikariConfig.setDriverClassName(driverName);
                hikariDataSource = new HikariDataSource(hikariConfig);
                return hikariDataSource;
            }else{
                return null;
            }
        }


    }

}
