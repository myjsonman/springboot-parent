package com.kavy.rookiespringbootrabbitmq.routing;

import com.kavy.rookiespringbootrabbitmq.util.ConnectionUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Send {
    private static final String EXCHANG_NAME ="test_exchang_direct";
    public static void main(String[] args) throws IOException, TimeoutException {

        //获取连接
        Connection connection = ConnectionUtils.getConnection();

        //获取一个通道
        Channel channel = connection.createChannel();
      //exchange
        channel.exchangeDeclare(EXCHANG_NAME,"direct");
        String msg = "hello diret!";

        String routingkey ="info";
        channel.basicPublish(EXCHANG_NAME,routingkey,null,msg.getBytes());
        System.out.println("send msg:"+msg);
        channel.close();
        connection.close();
    }
}
