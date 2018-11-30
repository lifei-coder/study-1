package com.hualala.internal.exchange;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class ProducerByFanoutExchange {
    public static void main(String[] args) throws Exception{
        // 1创建ConnectionFactory
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("172.16.32.107");
        connectionFactory.setVirtualHost("/");
        connectionFactory.setPort(5672);
        // 2创建Connection
        Connection connection = connectionFactory.newConnection();
        // 3创建channel
        Channel channel = connection.createChannel();
        // 4声明
        String exchangeName = "test_fanout_exchange";
        for (int i = 0; i < 10; i++) {
            String msg = "hello Fanout Exchange Message" + i;
            channel.basicPublish(exchangeName, "", null, msg.getBytes());
        }
    }
}
