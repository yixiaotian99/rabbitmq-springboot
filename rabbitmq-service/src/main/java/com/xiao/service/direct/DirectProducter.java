package com.xiao.service.direct;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Author sunjinwei
 * @Date 2020-06-19 21:35
 * @Description 使用 rabbitmq 默认的 direct 模式投递消息
 **/
@Slf4j
@Component
public class DirectProducter {


    private final String queueName = "test_queue_02";


    @Autowired
    private RabbitTemplate rabbitTemplate;


    public String send(String content) {

        String msg = content + ":" + new Date();
        log.info("send msg: {}", msg);

        rabbitTemplate.convertAndSend(queueName, msg);

        return msg;
    }

}
