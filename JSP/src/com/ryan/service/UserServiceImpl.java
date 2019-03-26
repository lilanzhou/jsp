package com.ryan.service;

import com.ryan.dao.UserDaoImpl;
import com.ryan.vo.User;

import java.util.List;

/**
 * Created by Administrator on 2019:03:22
 *
 * @Author : Lilanzhou
 * 功能 :
 */
public class UserServiceImpl {
    private UserDaoImpl dao=new UserDaoImpl();

    public List<User> queryAll(){
        return dao.queryAll();
    }
    public boolean del(int id){
        return dao.del(id);
    }
    public boolean add(User user){
        return dao.add(user);
    }
    public User queryById(int id){
        return dao.queryById(id);
    }
    public boolean updateByQueryId(User user){
        return dao.updateByQueryId(user);
    }
}
