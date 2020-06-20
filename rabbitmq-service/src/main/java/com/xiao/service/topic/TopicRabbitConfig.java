package com.xiao.service.topic;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @Author sunjinwei
 * @Date 2020-06-19 23:04
 * @Description 使用 topic 模式 rabbitmq 配置
 **/
@Configuration
public class TopicRabbitConfig {

    /**
     * 队列名称
     */
    final static String queueName1 = "topic.queue.aa";

    final static String queueName2 = "topic.queue.bb";

    /**
     * 创建队列
     *
     * @return
     */
    @Bean
    public Queue queueOne() {
        return new Queue(TopicRabbitConfig.queueName1);
    }

    @Bean
    public Queue queueTwo() {
        return new Queue(TopicRabbitConfig.queueName2);
    }


    /**
     * 声明交换器
     */
    @Bean
    public TopicExchange exchange() {
        return new TopicExchange("exchange");
    }

    /**
     * 绑定 交换器与 队列
     * 路由键 topic.queue.aa 全匹配
     */
    @Bean
    Binding bindingExchangeMessage(Queue queueOne, TopicExchange exchange) {
        return BindingBuilder.bind(queueOne).to(exchange).with("topic.queue.aa");
    }


    /**
     * 绑定 交换器与 队列
     * 路由键 topic.queue.# 模糊匹配
     */
    @Bean
    Binding bindingExchangeMessages(Queue queueTwo, TopicExchange exchange) {
        return BindingBuilder.bind(queueTwo).to(exchange).with("topic.queue.#");
    }

}
