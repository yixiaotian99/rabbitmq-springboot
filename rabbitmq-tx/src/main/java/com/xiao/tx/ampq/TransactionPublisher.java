package com.xiao.tx.ampq;

import cn.hutool.core.thread.ThreadUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

/**
 * @Author sunjinwei
 * @Date 2020-06-20 10:06
 * @Description 事务生产者
 **/
@Slf4j
@Component
public class TransactionPublisher implements RabbitTemplate.ReturnCallback {

    @Autowired
    private RabbitTemplate txRabbitTemplate;

    @PostConstruct
    public void init() {
        // 将信道设置为事务模式
        txRabbitTemplate.setChannelTransacted(true);
        txRabbitTemplate.setReturnCallback(this);
    }


    @Override
    public void returnedMessage(Message message, int i, String s, String s1, String s2) {
        log.error("事务执行失败! msg:{}", message);
    }


    /**
     * 声明事务消息
     */
    @Transactional(rollbackFor = Exception.class, transactionManager = "rabbitTransactionManager")
    public String sendTxMsg(String msg) {

        log.info("发送事务消息: msg:{}", msg);

        txRabbitTemplate.convertAndSend(TxRabbitConfig.queueName, msg);

        //模拟 rabbitmq 宕机
        ThreadUtil.sleep(1000);


        return msg;
    }
}













