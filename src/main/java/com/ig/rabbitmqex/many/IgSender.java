package com.ig.rabbitmqex.many;

import com.ig.rabbitmqex.json.JsonReceiver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class IgSender {
    private static final Logger LOGGER = LogManager.getLogger(IgSender.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;


    public void send(int i) {
        String context = "spring boot ig queue(" + String.valueOf(i) + ")";
        LOGGER.debug("IgSender : " + context);
        this.rabbitTemplate.convertAndSend("ig.queue", context);
    }

}
