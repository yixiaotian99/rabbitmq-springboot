package com.xiao.service.direct;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @Author sunjinwei
 * @Date 2020-06-19 21:40
 * @Description rabbitMQ 配置
 **/
@Configuration
public class RabbitConfig {


    private final String queueName = "test_queue_02";

    @Bean
    Queue queue() {
        return new Queue(queueName, false);
    }

}
