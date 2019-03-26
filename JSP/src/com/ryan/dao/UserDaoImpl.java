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
 * Created by Administrator on 2019:03:22
 *
 * @Author : Lilanzhou
 * 功能 :
 */
public class UserDaoImpl {
    private Connection connection = null;

    public UserDaoImpl() {
        connection = DB.getConn();
    }
   public boolean updateByQueryId(User user){
       PreparedStatement pstm=null;
     String sql="update userdemo set username=?,password=? where id=?";
     boolean flag=false;
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
    public User queryById(int id) {
        PreparedStatement psttm = null;
        String sql = "select * from userdemo where id=?";
        User user = null;
        ResultSet rs = null;
        try {
            psttm = connection.prepareStatement(sql);
            psttm.setInt(1, id);
            rs = psttm.executeQuery();
            while (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
                user = new User(username, password, id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (psttm != null) {
                try {
                    psttm.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return user;
    }

    public boolean add(User user) {
        PreparedStatement pstm = null;
        boolean flag = false;
        String sql = "insert into userdemo(username,password) value(?,?)";
        try {
            pstm = connection.prepareStatement(sql);
            pstm.setString(1, user.getUsername());
            pstm.setString(2, user.getPassword());
            flag = pstm.executeUpdate() > 0;
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
        return flag;
    }

    public boolean del(int id) {
        PreparedStatement pstm = null;
        boolean flag = false;
        String sql = "delete from userdemo where id=?";
        try {
            pstm = connection.prepareStatement(sql);
            pstm.setInt(1, id);
            flag = pstm.executeUpdate() > 0;
            System.out.println(id);
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
        return flag;
    }

    public List<User> queryAll() {
        PreparedStatement pstn = null;
        ResultSet rs = null;
        String sql = "select * from userdemo";
        List<User> list = new ArrayList<>();
        try {
            pstn = connection.prepareStatement(sql);
            rs = pstn.executeQuery();
            while (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
                int id = rs.getInt("id");
                User user = new User(username, password, id);
                list.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (pstn != null) {
                try {
                    pstn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return list;
    }
}
