package com.xiao.tx.ampq;


import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author sunjinwei
 * @Date 2020-06-20 16:43
 * @Description TODO
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
class TransactionPublisherTest {


    @Autowired
    private TransactionPublisher transactionPublisher;


    @Test
    void sendTxMsg() {

        for (int i = 0; i < 10; i++) {
            transactionPublisher.sendTxMsg("事务消息: " + i);
        }

    }
}