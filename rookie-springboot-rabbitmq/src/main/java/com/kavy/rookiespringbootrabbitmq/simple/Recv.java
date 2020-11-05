package com.kavy.rookiespringbootrabbitmq.simple;

import com.kavy.rookiespringbootrabbitmq.util.ConnectionUtils;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Recv {
    private static String QUEUE_NAME ="test_simple_queue";
    public static void main(String[] args) throws IOException, TimeoutException {
        //获取连接
        Connection connection = ConnectionUtils.getConnection();

        //获取一个通道
        Channel channel = connection.createChannel();

        //队列声明
        /**
         * 参数说明
         *  参数一：队列名称
         *  参数二：是否定义持久化队列
         *  参数三：是否独占本次连接
         *  参数四：是否在不使用的时候自动删除队列
         *  参数五：队列其他参数
         */
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);

        /**
         * consumerTag:消息者标签，在chuannel.basicConsume时候可以指定
         * envelope:消息包含内容,可以从中获取消息id,消息routingkey,交换机,消息和重转标记（收到消息失败后是否需要重新发送）
         * properties:消息属性
         * body:消息
         */
        DefaultConsumer defaultConsumer = new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                super.handleDelivery(consumerTag, envelope, properties, body);
                String msg = new String(body,"utf-8");
                System.out.println("new api recv:"+ msg);
            }
        };

        //监听队列
        channel.basicConsume(QUEUE_NAME,true,defaultConsumer);
    }
}
