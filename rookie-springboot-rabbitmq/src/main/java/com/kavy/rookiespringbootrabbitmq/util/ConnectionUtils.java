package com.kavy.rookiespringbootrabbitmq.util;


import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.springframework.boot.autoconfigure.amqp.RabbitProperties;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class ConnectionUtils {

    /**
     * 获取 MQ连接
     * @return
     */
    public static Connection getConnection() throws IOException , TimeoutException {

        //定义连接工厂
        ConnectionFactory factory = new ConnectionFactory();

        //设置服务地址
        factory.setHost("111.230.153.45");

        //设置端口
        factory.setPort(5672);

        //设置数据库
        factory.setVirtualHost("/vhost_xin");

        //设置用户
        factory.setUsername("user_xin");

        //设置密码
        factory.setPassword("123");
        return   factory.newConnection();
    }
}
