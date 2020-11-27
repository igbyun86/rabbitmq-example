package com.ig.rabbitmqex.object;

import com.ig.rabbitmqex.object.model.User;
import com.ig.rabbitmqex.topic.TopicReceiver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class ObjectSender {
    private static final Logger LOGGER = LogManager.getLogger(ObjectSender.class);


    @Autowired
    private RabbitTemplate rabbitTemplate;


    public void send(User user) {
        LOGGER.debug("object send: " + user);

        rabbitTemplate.convertAndSend("object.queue", user);
    }


    public void send2(User user) {
        LOGGER.debug("user send: " + user);
        rabbitTemplate.convertAndSend("object.user.queue", user);
    }



}
