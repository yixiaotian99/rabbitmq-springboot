package com.xiao.service.topic;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Author sunjinwei
 * @Date 2020-06-19 23:14
 * @Description TODO
 **/
@Slf4j
@Component
public class TopicProducter {

    /**
     * 路由key
     */
    private final String routingKeyAA = "topic.queue.aa";
    private final String routingKeyLike = "topic.queue.mm";


    @Autowired
    private RabbitTemplate rabbitTemplate;


    /**
     * 生产者
     *
     * @param content
     * @return
     */
    public String send_topic_aa(String content) {

        String msg = content + ":" + new Date();
        log.info("topic send1 msg: {}", msg);

        rabbitTemplate.convertAndSend("exchange", routingKeyAA, msg);

        return msg;
    }


    /**
     * 消费者
     *
     * @param content
     * @return
     */
    public String send_topic_like(String content) {

        String msg = content + ":" + new Date();
        log.info("topic send2 msg: {}", msg);

        rabbitTemplate.convertAndSend("exchange", routingKeyLike, msg);

        return msg;
    }
}
