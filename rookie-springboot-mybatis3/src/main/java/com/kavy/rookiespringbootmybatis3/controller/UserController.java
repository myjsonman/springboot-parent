package com.kavy.rookiespringbootmybatis3.controller;

import com.kavy.rookiespringbootmybatis3.entity.User;
import com.kavy.rookiespringbootmybatis3.service.UserService;
import com.kavy.rookiespringbootmybatis3.utils.ResultJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/queryUserAndPhone/{userId}")
    public ResultJson<User> queryUserAndPhone(@PathVariable Integer userId){
        List<User> users = userService.queryUserAndPhone(userId);
        for (User user : users) {
            System.out.println(user);
        }
        return ResultJson.ok(users);
    }
}
