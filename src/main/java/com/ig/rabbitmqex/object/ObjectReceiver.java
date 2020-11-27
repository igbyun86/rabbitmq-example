package com.ig.rabbitmqex.object;

import com.ig.rabbitmqex.object.model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

@Component
public class ObjectReceiver {

    private static final Logger LOGGER = LogManager.getLogger(ObjectSender.class);

    @RabbitListener(queues = "object.queue")
    public void receiver(Message message) {
        LOGGER.debug("object receiver: " +  message);

        User user = null;
        try {
            ByteArrayInputStream bis = new ByteArrayInputStream(message.getBody());
            ObjectInputStream ois = new ObjectInputStream(bis);
            user = (User) ois.readObject();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }

        LOGGER.debug("object receiver convert: " +  user);
    }


    @RabbitListener(queues = "object.user.queue")
    public void receiver2(User user) {
        LOGGER.debug("user receiver: " +  user.getId());
    }

}
