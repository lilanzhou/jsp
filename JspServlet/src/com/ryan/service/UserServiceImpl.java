package com.ryan.service;

import com.ryan.dao.UserDaoImpl;
import com.ryan.vo.User;

import java.util.List;

/**
 * Created by Administrator on 2019:03:23
 *
 * @Author : Lilanzhou
 * 功能 :
 */
public class UserServiceImpl {
    private UserDaoImpl dao=new UserDaoImpl();
    public List<User> queryAll(){
        return dao.queryALL();
    }
    public boolean add(User user){
        return dao.add(user);
    }
    public boolean deleteById(int id){
        return dao.deleteById(id);
    }
    public User queryId(int id){
        return dao.queryId(id);
    }
    public boolean updateByQueryId(User user) {

    return dao.updateByQueryId(user);
    }
}
