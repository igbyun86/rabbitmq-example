package com.ig.rabbitmqex.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TopicRabbitMQConfiguration {

    private final static String QUEUE_NAME = "topic.queue";
    private final static String QUEUE_NAMES = "topic.queues";
    private final String TOPIC_EXCHANGE_NAME = "spring.ig.topic";


    @Bean
    public Queue queueMessage() {
        return new Queue(QUEUE_NAME);
    }

    @Bean
    public Queue queueMessages() {
        return new Queue(QUEUE_NAMES);
    }

    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange(TOPIC_EXCHANGE_NAME);
    }

    @Bean
    public Binding bindingExchangeMessage() {
        return BindingBuilder.bind(queueMessage())
                .to(topicExchange())
                .with("topic.ig.message");
    }


    @Bean
    public Binding bindingExchangeMessages() {
        return BindingBuilder.bind(queueMessages())
                .to(topicExchange())
                .with("topic.ig.#");
    }
}
