package com.ig.rabbitmqex;

import com.ig.rabbitmqex.topic.TopicSender;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TopicTest {

    @Autowired
    private TopicSender sender;

    @Test
    public void topicSendTest() throws Exception {
        sender.send();
    }


    @Test
    public void topicSendTest1() throws Exception {
        sender.sendAll();
    }

    @Test
    public void topicSendTest2() throws Exception {
        sender.send2();
    }
}
