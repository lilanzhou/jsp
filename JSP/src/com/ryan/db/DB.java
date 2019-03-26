package com.ryan.db;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by Administrator on 2019:03:22
 *
 * @Author : Lilanzhou
 * 功能 :
 */
public class DB {
    private static Connection conn;
    public static Connection getConn(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url="jdbc:mysql://127.0.0.1/test?useUnicode=true&character=utf-8";
            String username="root";
            String password="root";
            conn= DriverManager.getConnection(url,username,password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}
