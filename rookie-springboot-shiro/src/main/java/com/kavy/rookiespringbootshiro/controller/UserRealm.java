package com.kavy.rookiespringbootshiro.controller;

import com.kavy.rookiespringbootshiro.entity.ActivUser;
import com.kavy.rookiespringbootshiro.entity.User;
import com.kavy.rookiespringbootshiro.service.*;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;


import java.util.List;

public class UserRealm extends AuthorizingRealm {

    private UserService userService = new UserServiceImp();
    private RoleService roleService = new RoleServiceImp();
    PermissionService permissionService = new PermissionServiceImp();

    /**
     * 做认证
     * @param authenticationToken
     * @return
     * @throws
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //密码凭证
       // authenticationToken.getCredentials();
        //身份
        String userName = authenticationToken.getPrincipal().toString();

        User user = userService.selectUser(userName);
        if (null != userName){
            List<String> roles  = roleService.queryRole(userName);
            System.out.println("roles-->" +roles);
            List<String> permissions  = permissionService.queryPermission(userName);

            ActivUser activUser = new ActivUser(user,roles,permissions);

            System.out.println("");
            /**
             * 参数说明：
             * 参数1：可以传任意对象
             * 参数2：从数据库里面查询出来的密码
             * 参数3：当前类名
             */
            SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(activUser,user.getPassword(),this.getName());
            return info;
        }else {

            return null;
        }

    }

    /**
     *  做授权
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        ActivUser activUser = (ActivUser) principals.getPrimaryPrincipal();
        System.out.println("activUser--->"+activUser);
        System.out.println("doGetAuthorizationInfo");
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();


        List<String> roles = activUser.getRoles();
        if (null!=roles && roles.size()>0){

            info.addRoles(roles);
        }

        List<String> permissions = activUser.getPermissions();
        if (null!= permissions && permissions.size()>0){

            info.addStringPermissions(permissions);
        }
        //如果是超级管理员
        if (activUser.getUser().getType() == 0){
            info.addStringPermission("*:*");
        }
        return info;
    }
}
