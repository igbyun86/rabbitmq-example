package com.ig.rabbitmqex.config;


import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FanoutRabbitMQConfiguration {

    @Bean
    public Queue igAQueue() {
        return new Queue("ig.fanout.A");
    }

    @Bean
    public Queue igBQueue() {
        return new Queue("ig.fanout.B");
    }

    @Bean
    public Queue igCQueue() {
        return new Queue("ig.fanout.C");
    }

    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange("fanoutExchange");
    }

    @Bean
    public Binding bindingExchangeA(Queue igAQueue, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(igAQueue).to(fanoutExchange);
    }

    @Bean
    public Binding bindingExchangeB(Queue igBQueue, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(igBQueue).to(fanoutExchange);
    }

    @Bean
    public Binding bindingExchangeC(Queue igCQueue, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(igCQueue).to(fanoutExchange);
    }
}
