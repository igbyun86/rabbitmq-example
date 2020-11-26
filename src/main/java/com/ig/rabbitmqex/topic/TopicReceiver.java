package com.ig.rabbitmqex.topic;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class TopicReceiver {

    private static final Logger LOGGER = LogManager.getLogger(TopicReceiver.class);

    /**
     * routingKey가 일치하는 경우
     * @param message
     */
    @RabbitListener(queues = "topic.queue")
    public void receiver(Message message) {
        LOGGER.debug("Topic Receiver1  : " + message);
    }

}
