package com.hualala.internal;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Send {

    private final static String QUEUE_NAME = "hello";

    public static void main(String[] args) throws  Exception{
        // create Connection
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("172.16.32.107");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        // declare a queue to send message
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        String message = "hey judy! don't be afraid123";
        channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
        System.out.println("[x] Sent '" + message + "'");
        // close connection
        channel.close();
        connection.close();
    }
}
