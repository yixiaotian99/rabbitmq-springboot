package com.xiao.service.topic;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author sunjinwei
 * @Date 2020-06-19 23:44
 * @Description TODO
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
class TopicProducterTest {


    @Autowired
    private TopicProducter topicProducter;

    /**
     * 只将队列匹配到 topic.aa
     */
    @Test
    void send_topic_aa() {

        topicProducter.send_topic_aa("只匹配到 topic.aa 队列");

    }

    @Test
    void send_topic_like() {

        topicProducter.send_topic_like("模糊匹配到 topic.aa.# 所有队列");


    }
}