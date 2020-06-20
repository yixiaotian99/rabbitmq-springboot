package com.xiao.service.direct;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * @Author sunjinwei
 * @Date 2020-06-19 22:52
 * @Description 使用 Direct 消费者
 **/
@Slf4j
@Component
@RabbitListener(queues = DirectRabbitConfig.queueName)
public class DirectConsumer {


    /**
     * 消费者
     * @param msg
     */
    @RabbitHandler
    public void process(String msg){

        log.info("receive:{}", msg);


    }

}
