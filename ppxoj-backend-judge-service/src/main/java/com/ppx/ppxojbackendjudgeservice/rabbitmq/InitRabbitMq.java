package com.ppx.ppxojbackendjudgeservice.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import lombok.extern.slf4j.Slf4j;

/**
 * 用于创建测试程序用到的交换机和队列（只用在程序启动前执行一次）
 */
@Slf4j
public class InitRabbitMq {

    public static void doInit() {
        try {
            // 创建连接工厂
            ConnectionFactory factory = new ConnectionFactory();
            // 设置RabbitMQ服务器的主机名
            factory.setHost("localhost");
            // 创建新的连接
            Connection connection = factory.newConnection();
            // 创建通道（操作消息队列的客户端）
            Channel channel = connection.createChannel();

            // 定义交换机名称
            String EXCHANGE_NAME = "code_exchange";
            // 声明一个direct类型的交换机，用来转发消息
            channel.exchangeDeclare(EXCHANGE_NAME, "direct");

            // 定义队列名称，用于收发消息
            String queueName = "code_queue";
            // 声明一个队列
            // 参数：队列名、持久化、独占、自动删除、其他参数
            channel.queueDeclare(queueName, true, false, false, null);

            // 将队列绑定到交换机上，使用路由键"my_routingKey"
            channel.queueBind(queueName, EXCHANGE_NAME, "my_routingKey");

            // 记录成功日志
            log.info("消息队列启动成功");
        } catch (Exception e) {
            // 记录失败日志
            log.error("消息队列启动失败");
        }
    }

    public static void main(String[] args) {
        // 调用初始化方法
        doInit();
    }
}