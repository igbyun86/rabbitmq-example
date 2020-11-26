package com.ig.rabbitmqex.topic;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class TopicReceiver2 {
    private static final Logger LOGGER = LogManager.getLogger(TopicReceiver2.class);

    /**
     * routingKey가 일부 패턴이 일치하는 경우
     * @param message
     */
    @RabbitListener(queues = "topic.queues")
    public void receiver(Message message) {
        LOGGER.debug("Topic Receiver2  : " + message);
    }

    /**
     * Runtime시 Binding하여 routingKey가 일치하는 경우
     * @param message
     */
    @RabbitListener(bindings = @QueueBinding(
            exchange = @Exchange(name="spring.ig.topic", type = ExchangeTypes.TOPIC),
            value = @Queue(name = "topic.queue"),
            key = "topic.ig.zzz"
    ))
    public void receiver2(Message message) {
        LOGGER.debug("Topic Runtime Binding Receiver  : " + message);
    }
}
