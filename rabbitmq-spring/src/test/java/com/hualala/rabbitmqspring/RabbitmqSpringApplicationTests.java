package com.hualala.rabbitmqspring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;


@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitmqSpringApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Autowired
    private RabbitAdmin rabbitAdmin;
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void testAdminDeclare(){
        // 声明三个exchange
        rabbitAdmin.declareExchange(new DirectExchange("test.direct", false, false));
        rabbitAdmin.declareExchange(new TopicExchange("test.topic", false, false));
        rabbitAdmin.declareExchange(new FanoutExchange("test.fanout", false, false));
        // 声明3个queue
        rabbitAdmin.declareQueue(new Queue("test.direct.queue"));
        rabbitAdmin.declareQueue(new Queue("test.topic.queue"));
        rabbitAdmin.declareQueue(new Queue("test.fanout.queue"));
    }

    @Test
    public void testBindingQueue(){
        // 建立绑定关系
        rabbitAdmin.declareBinding(new Binding("test.direct.queue", Binding.DestinationType.QUEUE,
                "test.direct", "direct", new HashMap<>()));

        // 建立绑定关系通过BindingBuilder，链式调用.bing(Queue queue).to(Exchange exchange).with(String routingKey)
        rabbitAdmin.declareBinding(BindingBuilder
                .bind(new Queue("test.topic.queue"))
                .to(new TopicExchange("test.topic", false, false))
                .with("user.#"));

        /**
         * fanout类型的exchange与queue绑定，不走routingKey，不用调用with方法
         */
        rabbitAdmin.declareBinding(BindingBuilder
                .bind(new Queue("test.fanout.queue"))
                .to(new FanoutExchange("test.fanout", false, false)));
    }

    @Test
    public void purgeQueryTest() {
        rabbitAdmin.purgeQueue("test.topic.queue", false);
    }

    @Test
    public void sendMessage1() {
        // 1.创建消息
        MessageProperties messageProperties = new MessageProperties();
        messageProperties.getHeaders().put("desc", "信息描述...");
        messageProperties.getHeaders().put("type", "自定义消息类型...");
        Message message = new Message("hello  你好, MessageListenerAdapter".getBytes(), messageProperties);
        // 2.发送
        rabbitTemplate.convertAndSend("topic001", "spring.amqp", message, new MessagePostProcessor() {
            @Override
            public Message postProcessMessage(Message message) throws AmqpException {
                System.out.println("---------添加额外的设置---------");
                message.getMessageProperties().getHeaders().put("desc", "额外修改的信息描述");
                message.getMessageProperties().getHeaders().put("attr", "额外新家的属性");
                return message;
            }
        });
    }

    @Test
    public void sendMessage2(){
//        MessageProperties messageProperties = new MessageProperties();
//        messageProperties.setContentType("text/plain");
//        Message message = new Message("mq 消息1234".getBytes(), messageProperties);

        rabbitTemplate.convertAndSend("topic001", "spring.amqp", "hello object message send");
        rabbitTemplate.convertAndSend("topic002", "rabbit.amqp", "hello object message send");
    }
}

