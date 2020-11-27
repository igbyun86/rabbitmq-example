package com.ig.rabbitmqex.json;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class JsonReceiver {
    private static final Logger LOGGER = LogManager.getLogger(JsonReceiver.class);

    @RabbitListener(queues = "json.queue")
    public void receiver(Message message) {
        LOGGER.debug("json message receiver: " +  message);
        LOGGER.debug("json string receiver: " +  new String(message.getBody()));



    }

}
