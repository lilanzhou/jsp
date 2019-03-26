package com.ryan.vo;

import java.io.Serializable;

/**
 * Created by Administrator on 2019:03:22
 *
 * @Author : Lilanzhou
 * 功能 :
 */
public class User implements Serializable {
    private String username;
    private String password;
    private int id;
    public User() {
    }
    public User(String username, String password,int id) {
        this.username = username;
        this.password = password;
        this.id=id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
