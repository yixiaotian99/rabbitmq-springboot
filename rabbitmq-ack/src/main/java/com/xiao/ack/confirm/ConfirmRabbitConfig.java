package com.xiao.ack.confirm;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @Author sunjinwei
 * @Date 2020-06-20 10:15
 * @Description 配置 rabbitmq 的确认模式
 **/
@Component
public class ConfirmRabbitConfig {

    final static String queueName = "test_queue_ack";

    @Bean
    Queue queue() {
        return new Queue(queueName, false);
    }


    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange("topic_exchange");
    }


    @Bean
    public Binding binding(TopicExchange topicExchange, Queue queue) {
        return BindingBuilder.bind(queue).to(topicExchange).with("test_queue_ack");
    }

}
