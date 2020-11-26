package com.ig.rabbitmqex.config;

import com.rabbitmq.client.ShutdownSignalException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.rabbit.connection.Connection;
import org.springframework.amqp.rabbit.connection.ConnectionListener;


public class CustomConnectionListener implements ConnectionListener {
    private static final Logger LOGGER = LogManager.getLogger(CustomConnectionListener.class);

    @Override
    public void onCreate(Connection connection) {
        LOGGER.debug("===== connection create =====");
    }

    @Override
    public void onClose(Connection connection) {
        LOGGER.debug("===== connection close =====");
    }

    @Override
    public void onShutDown(ShutdownSignalException signal) {
        LOGGER.debug("===== connection shutdown =====");
        LOGGER.debug("reason : " + signal.getReason());
    }
}
