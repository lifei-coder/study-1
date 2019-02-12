package com.hualala.rabbitmqspring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
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
}

