package com.xiao.service.direct;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author sunjinwei
 * @Date 2020-06-19 21:47
 * @Description TODO
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
class DirectProducterTest {


    @Autowired
    private DirectProducter directProducter;


    /**
     * 测试 direct 模式信息推送
     */
    @Test
    void sendTest() {

        directProducter.send("测试的消息!");

    }
}