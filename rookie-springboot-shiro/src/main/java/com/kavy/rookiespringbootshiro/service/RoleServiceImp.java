package com.kavy.rookiespringbootshiro.service;

import java.util.Arrays;
import java.util.List;

public class RoleServiceImp implements RoleService {
    @Override
    public List<String> queryRole(String userName) {
        return Arrays.asList("role1","role2","role3");
    }
}
