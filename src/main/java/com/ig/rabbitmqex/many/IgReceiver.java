package com.ig.rabbitmqex.many;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import sun.plugin2.message.Message;

@Component
@RabbitListener(queues = "ig.queue")
public class IgReceiver {
    private static final Logger LOGGER = LogManager.getLogger(IgReceiver.class);

    @RabbitHandler
    public void process(String message) {
        LOGGER.debug("Receiver 1:" + message);
    }

}
