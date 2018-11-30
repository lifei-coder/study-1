package com.hualala.internal.exchange;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class ProducerByTopicExchange {

    public static void main(String[] args) throws Exception {
        // 1创建ConnectionFactory
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("172.16.32.107");
        connectionFactory.setPort(5672);
        connectionFactory.setVirtualHost("/");
        // 2创建Connection
        Connection connection = connectionFactory.newConnection();
        // 3创建channel
        Channel channel = connection.createChannel();
        // 4声明
        String exchangedName = "test_topic_exchange";
        String routingKey = "test.topic";
        // 5发送message
        String msg = "Hello Top Exchange Message!";
        channel.basicPublish(exchangedName, routingKey, null, msg.getBytes());
    }

}
