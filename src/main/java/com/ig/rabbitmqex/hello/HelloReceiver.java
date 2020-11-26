package com.ig.rabbitmqex.hello;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class HelloReceiver {
    private static final Logger LOGGER = LogManager.getLogger(HelloReceiver.class);

    @RabbitListener(queues = "hello.world.queue")
    public void receiveMessage(final Message message) {
        LOGGER.debug("hello receive : " + message);
    }

}
