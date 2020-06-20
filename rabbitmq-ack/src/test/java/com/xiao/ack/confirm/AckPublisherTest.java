package com.xiao.ack.confirm;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author sunjinwei
 * @Date 2020-06-20 17:38
 * @Description TODO
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
class AckPublisherTest {

    @Autowired
    private AckPublisher ackPublisher;

    @Test
    void sendAckMsg() {

        for (int i = 0; i < 10; i++) {
            ackPublisher.sendAckMsg("发送确认消息: " + i);
        }
    }
}