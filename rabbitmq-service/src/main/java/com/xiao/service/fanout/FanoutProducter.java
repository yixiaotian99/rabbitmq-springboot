package com.xiao.service.fanout;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Author sunjinwei
 * @Date 2020-06-20 09:23
 * @Description 发布订阅生产者
 **/
@Slf4j
@Component
public class FanoutProducter {

    @Autowired
    private RabbitTemplate rabbitTemplate;


    public String send(String content) {

        String msg = content + ":" + new Date();
        log.info("fanout send msg: {}", msg);

        rabbitTemplate.convertAndSend("fanoutExchange", "", msg);

        return msg;
    }

}
