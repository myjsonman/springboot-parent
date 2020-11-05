package com.kavy.rookiespringbootshiro.service;

import java.util.Arrays;
import java.util.List;

public class PermissionServiceImp implements PermissionService {
    @Override
    public List<String> queryPermission(String userName) {

        return Arrays.asList("user:add","user:query","user:update");
    }
}
