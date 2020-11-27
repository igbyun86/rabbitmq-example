package com.ig.rabbitmqex;

import com.ig.rabbitmqex.object.ObjectSender;
import com.ig.rabbitmqex.object.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ObjectTest {

    @Autowired
    private ObjectSender objectSender;

    /**
     * 객체를 Message 파라미터로 받기
     */
    @Test
    public void object_파라미터_Test() {
        User user = new User("abcd", "spring", 10);

        objectSender.send(user);
    }

    /**
     * 객체를 객체로 받기
     */
    @Test
    public void user_파라미터_Test() {
        User user = new User("xyz", "boot", 20);
        objectSender.send2(user);
    }


}
