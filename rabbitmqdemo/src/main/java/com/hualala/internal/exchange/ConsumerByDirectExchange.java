package com.hualala.internal.exchange;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.QueueingConsumer;

public class ConsumerByDirectExchange {

    public static void main(String[] args) throws Exception{
        // 1创建ConnectionFactory
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("172.16.32.107");
        connectionFactory.setVirtualHost("/");
        connectionFactory.setPort(5672);

        connectionFactory.setAutomaticRecoveryEnabled(true);
        connectionFactory.setNetworkRecoveryInterval(3000);
        Connection connection = connectionFactory.newConnection();

        // 声明
        Channel channel = connection.createChannel();
        String exchangeName = "test_direct_exchange";
        String exchangeType = "direct";
        String routingKey = "test.direct";
        String queueName = "test_direct_queue";
        channel.exchangeDeclare(exchangeName, exchangeType,true,false,false,null);
        channel.queueDeclare(queueName,false,false,false,null);
        channel.queueBind(queueName, exchangeName, routingKey);

        QueueingConsumer consumer = new QueueingConsumer(channel);
        channel.basicConsume(queueName, true, consumer);
        while (true) {
            QueueingConsumer.Delivery delivery = consumer.nextDelivery();
            String msg = new String(delivery.getBody());
            System.out.println("收到消息: " +msg);
        }
    }

}
