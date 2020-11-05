package com.kavy.rookiespringbootshiro.service;

import com.kavy.rookiespringbootshiro.entity.User;

import java.util.Date;

public class UserServiceImp implements UserService {
    @Override
    public User selectUser(String userName) {
        User user = null;

        switch (userName){
            case "zhangsan":
                 user = new User(1,"zhangsan","123456",1,new Date());
                 break;
            case "lisi":
                user = new User(2,"lisi","123456",0,new Date());
                break;
            case "wangwu":
                user = new User(3,"wangwu","123456",0,new Date());
                break;
            default:
                break;
        }

        return user;
    }
}
