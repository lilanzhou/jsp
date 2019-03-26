package com.ryan.dao;

import com.ryan.db.DB;
import com.ryan.vo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019:03:23
 *
 * @Author : Lilanzhou
 * 功能 :
 */
public class UserDaoImpl {
    private Connection connection = null;
    private PreparedStatement pstm = null;
    boolean flag=false;
    public UserDaoImpl() {
        connection = DB.getCon();
    }

    public List<User> queryALL() {
        String sql = "select * from userdemo";
        ResultSet rs = null;
        List<User> list = new ArrayList<>();
        try {
            pstm = connection.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
                int id = rs.getInt("id");
                User user = new User();
                user.setId(id);
                user.setUsername(username);
                user.setPassword(password);
                list.add(user);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (pstm != null) {
                try {
                    pstm.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return list;
    }
    public boolean add(User user){
        String sql="insert into userdemo(username,password) value(?,?)";
        try {
            pstm=connection.prepareStatement(sql);
            pstm.setString(1,user.getUsername());
            pstm.setString(2,user.getPassword());
            flag=pstm.executeUpdate()>0;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(pstm!=null){
                try {
                    pstm.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return flag;
    }
    public boolean deleteById(int id){
        String sql="delete from userdemo where id=?";
        try {
            pstm=connection.prepareStatement(sql);
            pstm.setInt(1,id);
            flag=pstm.executeUpdate()>0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }
    public User queryId(int id){
        String sql="select * from userdemo where id=?";
        ResultSet rs=null;
        User user=null;
        try {
            pstm=connection.prepareStatement(sql);
            pstm.setInt(1,id);
            rs=pstm.executeQuery();
            while (rs.next()){
                String username=rs.getString("username");
                String password=rs.getString("password");

                user=new User(id,username,password);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
    public boolean updateByQueryId(User user){
        String sql="update userdemo set username=?,password=? where id=?";
        try {
            pstm=connection.prepareStatement(sql);
            pstm.setString(1,user.getUsername());
            pstm.setString(2,user.getPassword());
            pstm.setInt(3,user.getId());
            flag=pstm.executeUpdate()>0;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(pstm!=null){
                try {
                    pstm.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return flag;
    }
}
