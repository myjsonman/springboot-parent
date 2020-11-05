package com.kavy.rookiespringbootrabbitmq.ps;

import com.kavy.rookiespringbootrabbitmq.util.ConnectionUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Send {
   private final static String EXCHANG_NAME = "test_exchang_fanout";
    public static void main(String[] args) throws IOException, TimeoutException {

        //获取连接
        Connection connection = ConnectionUtils.getConnection();
        Channel channel = connection.createChannel();
        //声明交换机
        channel.exchangeDeclare(EXCHANG_NAME,"fanout");//分发

        //发送消息
        String msg = "hello ps";
        channel.basicPublish(EXCHANG_NAME,"",null,msg.getBytes());
        System.out.println("send msg:"+msg);
        channel.close();
        connection.close();
    }
}
