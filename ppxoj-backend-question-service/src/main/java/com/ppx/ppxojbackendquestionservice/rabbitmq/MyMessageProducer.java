package com.ppx.ppxojbackendquestionservice.rabbitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 消息生产者
 */
@Component
public class MyMessageProducer {

    // 自动生成客户端
    @Resource
    private RabbitTemplate rabbitTemplate;

    /**
     * 发送消息
     * @param exchange
     * @param routingKey
     * @param message
     */
    public void sendMessage(String exchange, String routingKey, String message) {
        // 发送消息，exchange 交换机，routingKey 路由键，message 消息
        rabbitTemplate.convertAndSend(exchange, routingKey, message);
    }

}