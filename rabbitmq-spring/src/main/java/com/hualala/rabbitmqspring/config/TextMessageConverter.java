package com.hualala.rabbitmqspring.config;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.support.converter.MessageConversionException;
import org.springframework.amqp.support.converter.MessageConverter;

public class TextMessageConverter implements MessageConverter {
    /**
     * Convert a Java Object to a Message
     * @param object
     * @param messageProperties
     * @return
     * @throws MessageConversionException
     */
    @Override
    public Message toMessage(Object object, MessageProperties messageProperties) throws MessageConversionException {
        return new Message(object.toString().getBytes(), messageProperties);
    }

    /**
     *
     * Convert from a Message to a Java Object。
     * before consume message, we can do something with the message
     * @param message
     * @return
     * @throws MessageConversionException
     */
    @Override
    public Object fromMessage(Message message) throws MessageConversionException {
        String contentType = message.getMessageProperties().getContentType();
        if (null != contentType && contentType.contains("text")) {
            // 若是纯文本的消息, 返回一个String.
            // 我们定义的MessageDelegate.consumeMessage(String messageBody)方法就会接受到此放回值
            return new String(message.getBody());
        }
        return message.getBody();
    }
}
