package com.kavy.rookiespringbootmybatis3.dao;

import com.kavy.rookiespringbootmybatis3.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    
    List<User> queryUserAndPhone(Integer userId);
}
