package com.kavy.rookiespringbootshiro.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestShiro {

    private static final transient Logger log = LoggerFactory.getLogger(TestShiro.class);
    public static void main(String[] args) {
        log.info("My First Apache Shiro Application");

         String userName = "lisi";
         String passWord = "123456";
        //获取ini文件
        DefaultSecurityManager defaultSecurityManager=new DefaultSecurityManager();
        IniRealm iniRealm=new IniRealm("classpath:shiro.ini");
        defaultSecurityManager.setRealm(iniRealm);

        //创建Realm
        UserRealm userRealm = new UserRealm();
        defaultSecurityManager.setRealm(userRealm);
        //把defaultSecurityManager绑定到SecurityManager
        SecurityUtils.setSecurityManager(defaultSecurityManager);


       /* // 1，创建安全管理器的工厂对象 org.apache.shiro.mgt.SecurityManager;  不能使用java.lang.SecurityManager
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
        // 2,使用工厂创建安全管理器
        SecurityManager securityManager = factory.getInstance();
        // 3,把当前的安全管理器绑定当到线的线程
        SecurityUtils.setSecurityManager(securityManager);*/


        //获取当前subject
        Subject subject = SecurityUtils.getSubject();

        //封装用户名和密码
        AuthenticationToken token = new UsernamePasswordToken(userName,passWord);

        //得到认证
        try {
            subject.login(token);
            System.out.println("认证通过！");
        } catch (AuthenticationException e) {
            System.out.println("用户名或密码错误");
            e.printStackTrace();
        }

        boolean role1 = subject.hasRole("role1");
        System.out.println("是否有role1的权限：" + role1);

        boolean permitted = subject.isPermitted("user:add");
        System.out.println(permitted);

    }
}
