package com.kavy.rookiespringbootrabbitmq.confirm;

import com.kavy.rookiespringbootrabbitmq.util.ConnectionUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class ConfirmSend {
    private static final String QUEUE_NAME = "test_queue_confirm";
    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
        Connection connection = ConnectionUtils.getConnection();
        Channel channel = connection.createChannel();

        String msg = "hello confirm!";
        channel.basicPublish("",QUEUE_NAME,null,msg.getBytes());
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);

        //生产者调用confirmSelect，将channel设为confirm模式
        channel.confirmSelect();
        if (!channel.waitForConfirms()){

            System.out.println("send msg failed");
        }else {
            System.out.println("send msg ok");
        }
        channel.close();
        connection.close();
    }
}
