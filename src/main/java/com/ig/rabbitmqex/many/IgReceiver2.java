package com.ig.rabbitmqex.many;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "ig.queue")
public class IgReceiver2 {
    private static final Logger LOGGER = LogManager.getLogger(IgReceiver2.class);

    @RabbitHandler
    public void process(String message) {
        LOGGER.debug("Receiver 2:" + message);
    }

}
