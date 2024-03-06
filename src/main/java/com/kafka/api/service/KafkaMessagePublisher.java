package com.kafka.api.service;

import com.kafka.api.constant.AppConstant;
import com.kafka.api.dto.Customer;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
public class KafkaMessagePublisher {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaMessagePublisher.class);
    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    public void sendMessageToTopic(String message) {
        LOGGER.info("text message sending...");
        kafkaTemplate.send(AppConstant.TOPIC_NAME, message);
        LOGGER.info("message>>> " + message);
    }

    public void sendEventsToTopic(Customer customer) {
        try {
            LOGGER.info("customer message sending...");
            kafkaTemplate.send(AppConstant.TOPIC_NAME, customer);
            LOGGER.info("customer:: " + customer);
        } catch (Exception ex) {
            System.out.println("ERROR : " + ex.getMessage());
        }
    }
}
