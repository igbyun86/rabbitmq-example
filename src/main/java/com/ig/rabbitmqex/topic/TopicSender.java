package com.ig.rabbitmqex.topic;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.core.MessagePropertiesBuilder;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * exchange type이 topic인 경우
 * topic.ig.~ 로 시작하는 routingKey는 topic.ig.#의 큐를 매핑한다
 */
@Component
public class TopicSender {
    private static final Logger LOGGER = LogManager.getLogger(TopicSender.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * routingKey가 topic.ig.message인 큐와
     * topic.ig.~ 로 시작하는 큐로 메시지를 보냄
     * 전체가 일치하거나 일부 패턴이 일치하는 모든 Queue로 메시지 전달
     */
    public void sendAll() {
        String message = "Hello World message all";
        LOGGER.debug("topic sender : " + message);
        this.rabbitTemplate.convertAndSend("spring.ig.topic", "topic.ig.message", message);

    }

    /**
     * 일부 패턴이 일치하는 큐와 Receive에서 Runtime시 Binding하여
     * routingKey가 일치하는 Queue로 메시지 전달
     */
    public void send() {
        String body = "Hello World zzz";

        MessageProperties props = MessagePropertiesBuilder.newInstance()
                .setContentType(MessageProperties.CONTENT_TYPE_TEXT_PLAIN)
                .setMessageId("123")
                .setHeader("bar", "baz")
                .build();

        Message message = MessageBuilder.withBody(body.getBytes())
                .andProperties(props)
                .build();

        LOGGER.debug("topic sender : " + body);
        this.rabbitTemplate.convertAndSend("spring.ig.topic", "topic.ig.zzz",message);
    }

    /**
     * 일부 패턴이 일치하는 Queue로 메시지 전달
     */
    public void send2() {
        String message = "Hello World aaa";
        LOGGER.debug("topic sender : " + message);
        this.rabbitTemplate.convertAndSend("spring.ig.topic", "topic.ig.messages", message);
    }

}
