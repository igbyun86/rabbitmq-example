package com.ig.rabbitmqex;

import com.ig.rabbitmqex.many.IgSender;
import com.ig.rabbitmqex.many.IgSender2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ManyTest {

    @Autowired
    private IgSender igSender;

    @Autowired
    private IgSender2 igSender2;


    /**
     * 2개의 Receiver가 번갈아가며 나눠서 받음
     */
    @Test
    public void oneToMany() {
        for (int i = 0; i < 30; i++) {
            igSender.send(i);
        }
    }

    /**
     * 2개의 Receiver가 나눠서 받음
     */
    @Test
    public void manyToMany() {
        for (int i = 0; i < 20; i++) {
            igSender.send(i);
            igSender2.send(i);
        }
    }

}
