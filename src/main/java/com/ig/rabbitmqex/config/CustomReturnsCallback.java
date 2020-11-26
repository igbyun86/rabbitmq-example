package com.ig.rabbitmqex.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.core.ReturnedMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

public class CustomReturnsCallback implements RabbitTemplate.ReturnsCallback {

    private static final Logger LOGGER = LogManager.getLogger(CustomReturnsCallback.class);

    /**
     * message -반환 된 메시지 자체
     * replyCode -반품 사유를 나타내는 코드
     * replyText -반품에 대한 텍스트 이유-예 NO_ROUTE
     * exchange -메시지가 전송 된 교환
     * routingKey -사용 된 라우팅 키
     * @param returnedMessage
     */
    @Override
    public void returnedMessage(ReturnedMessage returnedMessage) {
        LOGGER.debug("return replyCode = " + returnedMessage.getReplyCode());
        LOGGER.debug("return message = " + returnedMessage.getMessage());
    }
}
