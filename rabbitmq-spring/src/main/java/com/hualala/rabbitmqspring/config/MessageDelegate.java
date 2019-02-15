package com.hualala.rabbitmqspring.config;

public class MessageDelegate {

    public void handleMessage(byte[] messageBody) {
        System.out.println("默认方法, 消息内容： " + new String(messageBody));
    }

    public void consumeMessage(byte[] messageBody) {
        System.out.println("consumeMessage 方法 接收消息：" + new String(messageBody));
    }


    public void consumeMessage(String messageBody) {
        System.out.println("字符串方法，  消息内容：" + messageBody);
    }
}
