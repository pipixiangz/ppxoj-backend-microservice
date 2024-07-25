package com.ppx.ppxojbackendjudgeservice.rabbitmq;

import com.rabbitmq.client.Channel;
import com.ppx.ppxojbackendjudgeservice.judge.JudgeService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
@Slf4j
public class MyMessageConsumer {

    @Resource
    private JudgeService judgeService;

    // 指定程序监听的消息队列和确认机制
    @SneakyThrows
    @RabbitListener(queues = {"code_queue"}, ackMode = "MANUAL") // 队列名称，ackMode = "MANUAL" 手动确认消息
    public void receiveMessage(String message, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long deliveryTag) {
        log.info("receiveMessage message = {}", message);

        // 将消息转换为 questionSubmitId
        long questionSubmitId = Long.parseLong(message);

        try {
            // 调用 judgeService 处理判题逻辑
            judgeService.doJudge(questionSubmitId);

            // 手动确认消息已被成功处理
            // 参数解释：deliveryTag（消息投递标签），multiple（是否批量确认）
            channel.basicAck(deliveryTag, false);
        } catch (Exception e) {
            // 处理失败，拒绝消息
            // 参数解释：deliveryTag（消息投递标签），multiple（是否批量拒绝），requeue（是否重新入队）
            channel.basicNack(deliveryTag, false, false);
        }
    }
}