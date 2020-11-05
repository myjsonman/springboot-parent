package com.kavy.rookiespringbootshiro.service;

import java.util.List;

public interface PermissionService {

    /**
     * 根据用户名查询用户拥有的权限
     * @param userName
     * @return
     */
    public List<String> queryPermission(String userName);
}
