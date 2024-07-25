package com.ppx.ppxojbackendjudgeservice.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * 用于创建测试程序用到的交换机和队列（只用在程序启动前执行一次）
 */
@Slf4j
@Component
public class InitRabbitMqBean {

    // 从配置文件中读取RabbitMQ服务器主机名，默认为localhost
    @Value("${spring.rabbitmq.host:localhost}")
    private String host;

    // 在Bean初始化完成后自动执行此方法
    @PostConstruct
    public void init() {
        try {
            // 创建RabbitMQ连接工厂
            ConnectionFactory factory = new ConnectionFactory();
            // 设置RabbitMQ服务器的主机名
            factory.setHost(host);
            // 创建新的连接
            Connection connection = factory.newConnection();
            // 创建通道
            Channel channel = connection.createChannel();

            // 定义交换机名称
            String EXCHANGE_NAME = "code_exchange";
            // 声明一个direct类型的交换机
            channel.exchangeDeclare(EXCHANGE_NAME, "direct");

            // 定义队列名称
            String queueName = "code_queue";
            // 声明一个队列
            // 参数：队列名、持久化、独占、自动删除、其他参数
            channel.queueDeclare(queueName, true, false, false, null);

            // 将队列绑定到交换机，使用路由键"my_routingKey"
            channel.queueBind(queueName, EXCHANGE_NAME, "my_routingKey");

            // 记录成功日志
            log.info("消息队列启动成功");
        } catch (Exception e) {
            // 记录失败日志，包括异常信息
            log.error("消息队列启动失败", e);
        }
    }
}
