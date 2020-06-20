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
public class DirectRabbitConfig {


    final static String queueName = "test_queue_03";

    @Bean
    Queue queue() {
        return new Queue(queueName, false);
    }

}
