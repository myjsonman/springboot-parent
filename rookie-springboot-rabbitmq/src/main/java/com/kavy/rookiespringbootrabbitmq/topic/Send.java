package com.kavy.rookiespringbootrabbitmq.topic;

import com.kavy.rookiespringbootrabbitmq.util.ConnectionUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Send {
    private static final String EXCHANG_NAME ="test_exchang_topic";
    public static void main(String[] args) throws IOException, TimeoutException {

        //获取连接
        Connection connection = ConnectionUtils.getConnection();

        //获取一个通道
        Channel channel = connection.createChannel();
      //exchange
        channel.exchangeDeclare(EXCHANG_NAME,"topic");
        String msgSting = "商品。。。。";

        channel.basicPublish(EXCHANG_NAME,"goods.delete",null,msgSting.getBytes());
        System.out.println("send msgSting:"+msgSting);
        channel.close();
        connection.close();
    }
}
