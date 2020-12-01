package com.ig.rabbitmqex.fanout;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "ig.fanout.C")
public class FanoutReceiverC {
    private static final Logger LOGGER = LogManager.getLogger(FanoutReceiverC.class);

    @RabbitHandler
    public void receiver(String msg) {
        LOGGER.debug("fanout Receiver C:" + msg);
    }
}
