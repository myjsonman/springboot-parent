package com.kavy.rookiespringbootmybatis3.service.Impl;

import com.kavy.rookiespringbootmybatis3.dao.UserMapper;
import com.kavy.rookiespringbootmybatis3.entity.User;
import com.kavy.rookiespringbootmybatis3.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public List<User> queryUserAndPhone(Integer userId) {
        return userMapper.queryUserAndPhone(userId);
    }
}
