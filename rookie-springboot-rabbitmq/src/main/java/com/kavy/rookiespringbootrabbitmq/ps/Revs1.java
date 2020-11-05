package com.kavy.rookiespringbootrabbitmq.ps;

import com.kavy.rookiespringbootrabbitmq.util.ConnectionUtils;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Revs1 {
    private static final String QUEUE_NAME = "test_queue_fanout_emial";
    private final static String EXCHANG_NAME = "test_exchang_fanout";
    public static void main(String[] args) throws IOException, TimeoutException {
        //获取连接
        Connection connection = ConnectionUtils.getConnection();

        //获取一个通道
        Channel channel = connection.createChannel();

        //队列声明
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);

        //绑定队列到交换机转发器
        channel.queueBind(QUEUE_NAME,EXCHANG_NAME,"");

        //保证一次只发一个
        channel.basicQos(1);

        //定义一个消费者
        DefaultConsumer consumer = new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                super.handleDelivery(consumerTag, envelope, properties, body);
                String msg = new String(body,"utf-8");
                System.out.println("[1]  Recv msg:"+ msg);

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    System.out.println("[1] done");
                    channel.basicAck(envelope.getDeliveryTag(),false);
                }
            }
        };

        //自动应答
        boolean autoAck = false;//自动应答 false
        channel.basicConsume(QUEUE_NAME,autoAck,consumer);
    }
}
