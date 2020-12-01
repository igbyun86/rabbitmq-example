package com.ig.rabbitmqex.fanout;

import com.ig.rabbitmqex.many.IgSender;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FanoutSender {
    private static final Logger LOGGER = LogManager.getLogger(FanoutSender.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send() {
        String msg = "hello, fanout msg";
        LOGGER.debug("fanout Sender: " + msg);
        this.rabbitTemplate.convertAndSend("fanoutExchange", "", msg);
    }

}
