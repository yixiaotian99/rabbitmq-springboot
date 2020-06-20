package com.xiao.tx.ampq;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.transaction.RabbitTransactionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @Author sunjinwei
 * @Date 2020-06-20 10:15
 * @Description 配置 rabbitmq 的事务模式
 **/
@Component
public class TxRabbitConfig {

    final static String queueName = "test_queue_tx";

    @Bean
    Queue queue() {
        return new Queue(queueName, false);
    }


    /**
     * 配置rabbitmq事务
     *
     * @param connectionFactory
     * @return
     */
    @Bean("rabbitTransactionManager")
    public RabbitTransactionManager rabbitTransactionManager(ConnectionFactory connectionFactory) {
        return new RabbitTransactionManager(connectionFactory);
    }

    @Bean
    public RabbitTemplate transactionRabbitTemplate(ConnectionFactory connectionFactory) {
        return new RabbitTemplate(connectionFactory);
    }
}
