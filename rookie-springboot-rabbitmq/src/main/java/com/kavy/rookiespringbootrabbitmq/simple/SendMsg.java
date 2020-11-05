package com.kavy.rookiespringbootrabbitmq.simple;

import com.kavy.rookiespringbootrabbitmq.util.ConnectionUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class SendMsg {
    private static String QUEUE_NAME ="test_simple_queue";
    public static void main(String[] args) throws IOException, TimeoutException {

        //获取连接
        Connection connection = ConnectionUtils.getConnection();

        //获取一个通道
        Channel channel = connection.createChannel();
        //创建队列声明
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);
        String msg = "hello simple";

        channel.basicPublish("",QUEUE_NAME,null,msg.getBytes());
        System.out.println("send msg :"+msg);
        channel.close();
        connection.close();
    }
}
