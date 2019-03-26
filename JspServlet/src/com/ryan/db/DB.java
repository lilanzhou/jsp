package com.ryan.db;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by Administrator on 2019:03:23
 *
 * @Author : Lilanzhou
 * 功能 :
 */
public class DB {
    private static Connection connection;
    public static Connection getCon(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url="jdbc:mysql://127.0.0.1/test?useUnicode=true&characterEncoding=utf-8";
            String username="root";
            String password="root";
            connection= DriverManager.getConnection(url,username,password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}
