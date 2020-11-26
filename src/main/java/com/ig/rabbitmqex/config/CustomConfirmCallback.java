package com.ig.rabbitmqex.config;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

public class CustomConfirmCallback implements RabbitTemplate.ConfirmCallback {

    private static final Logger LOGGER = LogManager.getLogger(CustomConfirmCallback.class);

    /**
     * CorrelationData 원본 메시지를 보낼 때 클라이언트가 제공하는 오브젝트
     * @param correlationData
     * @param ack
     * @param cause
     */
    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        LOGGER.debug("confirmCallback correlationData = " + correlationData);
        LOGGER.debug("confirmCallback cause = " + cause);
    }
}
