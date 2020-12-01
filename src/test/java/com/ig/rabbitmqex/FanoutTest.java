package com.ig.rabbitmqex;

import com.ig.rabbitmqex.fanout.FanoutSender;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class FanoutTest {

    @Autowired
    private FanoutSender fanoutSender;

    /**
     * exchange에 binding된 모든 queue에 발송한다.
     */
    @Test
    public void fanoutSendTest() {
        fanoutSender.send();
    }

}
