package com.ig.rabbitmqex.json;

import com.ig.rabbitmqex.json.model.Member;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class JsonSender {
    private static final Logger LOGGER = LogManager.getLogger(JsonSender.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;


    public void sendMember(Member member) {
        LOGGER.debug("json object send: " + member);

        rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
        rabbitTemplate.convertAndSend("json.queue", member);
    }

    public void sendMap(Map<String, Object> map) {
        LOGGER.debug("json map send: " + map);
        rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
        rabbitTemplate.convertAndSend("json.queue", map);
    }
}
