package com.ig.rabbitmqex;

import com.ig.rabbitmqex.hello.HelloSender;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class HelloTest {

    @Autowired
    private HelloSender helloSender;


    @Test
    public void helloSendTest() {
        helloSender.send();
    }

}
