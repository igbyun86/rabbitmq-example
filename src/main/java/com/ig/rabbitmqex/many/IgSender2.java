package com.ig.rabbitmqex.many;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class IgSender2 {
    private static final Logger LOGGER = LogManager.getLogger(IgSender2.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;


    public void send(int i) {
        String context = "spring boot ig queue(" + String.valueOf(i) + ")";
        LOGGER.debug("IgSender2 : " + context);
        this.rabbitTemplate.convertAndSend("ig.queue", context);
    }
}
