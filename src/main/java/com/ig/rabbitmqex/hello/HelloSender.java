package com.ig.rabbitmqex.hello;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class HelloSender {
    private static final Logger LOGGER = LogManager.getLogger(HelloSender.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send() {
        String message = "Hello rabbitmq (" + new Date() + ")";
        LOGGER.debug("hello sender : " + message);
        this.rabbitTemplate.convertAndSend(message);
    }

}
