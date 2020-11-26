package com.ig.rabbitmqex.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource(value="classpath:application.properties")
public class RabbitMQConfiguration {
    private static final Logger LOGGER = LogManager.getLogger(RabbitMQConfiguration.class);

    @Value("${spring.rabbitmq.host}")
    private String host;

    @Value("${spring.rabbitmq.port}")
    private int port;

    @Value("${spring.rabbitmq.username}")
    private String username;

    @Value("${spring.rabbitmq.password}")
    private String password;

    private final String DEFAULT_QUEUE_NAME = "hello.world.queue";



    @Bean
    public CachingConnectionFactory cachingConnectionFactory() throws Exception {
        CachingConnectionFactory ccf = new CachingConnectionFactory(host, port);
        ccf.setUsername(username);
        ccf.setPassword(password);

        // rabbitmq 서버가 cluster인 경우
        //ccf.setAddresses("host1:5672,host2:5672,host3:5672");
        //ccf.setAddressShuffleMode(AbstractConnectionFactory.AddressShuffleMode.RANDOM);	// 연결모드

        // listener 등록
        ccf.addConnectionListener(new CustomConnectionListener());

        return ccf;
    }

    @Bean
    public RabbitTemplate rabbitTemplate(CachingConnectionFactory cachingConnectionFactory) throws Exception {
        RabbitTemplate template = new RabbitTemplate(cachingConnectionFactory);

        /**
         * default exchange인 경우
         * type은 direct이고 목적지 queue이름과 동일한 routingKey를 부여한다.
         */
        template.setRoutingKey(this.DEFAULT_QUEUE_NAME);
        template.setDefaultReceiveQueue(this.DEFAULT_QUEUE_NAME);

        // message가 반환되는 경우 callback class 등록
        template.setReturnsCallback(new CustomReturnsCallback());

        //
        template.setConfirmCallback(new CustomConfirmCallback());

        return template;
    }



}
