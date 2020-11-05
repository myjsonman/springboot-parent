package com.kavy.rookiespringbootmybatis3.service;

import com.kavy.rookiespringbootmybatis3.entity.User;

import java.util.List;

public interface UserService {
   List<User> queryUserAndPhone(Integer userId);
}
