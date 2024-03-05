package com.kafka.api.producer;

import com.kafka.api.constant.AppConstant;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageProducer {

    private static final Logger LOGGER = LogManager.getLogger(MessageProducer.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message) {
        LOGGER.info(String.format("Sending message to " + AppConstant.TOPIC_NAME + " Topic:: %s", message));
        kafkaTemplate.send(AppConstant.TOPIC_NAME, message);
    }
}
