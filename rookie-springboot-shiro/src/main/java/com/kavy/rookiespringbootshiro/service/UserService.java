package com.kavy.rookiespringbootshiro.service;

import com.kavy.rookiespringbootshiro.entity.User;


public interface UserService {
    public User selectUser(String userName);
}
