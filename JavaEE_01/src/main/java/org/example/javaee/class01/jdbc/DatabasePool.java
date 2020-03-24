package org.example.javaee.class01.jdbc;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class DatabasePool {

    private static HikariDataSource hikariDataSource;

    public static HikariDataSource getHikariDataSource(){

        if(null != hikariDataSource){
            return null;
        }
        synchronized (DatabasePool.class){
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

//    public static void main(String[] args) throws InterruptedException {
//        while (true){
//            getHikariDataSource();
//            Thread.sleep(3000);
//        }
//
//    }

}
