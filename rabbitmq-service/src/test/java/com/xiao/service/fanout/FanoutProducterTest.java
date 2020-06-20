package com.xiao.service.fanout;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author sunjinwei
 * @Date 2020-06-20 09:28
 * @Description TODO
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
class FanoutProducterTest {


    @Autowired
    private FanoutProducter fanoutProducter;


    @Test
    void send() {

        fanoutProducter.send("我是订阅消息");

    }
}