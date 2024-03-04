package com.kafka.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.kafka.api.model.User;

@SpringBootApplication
@RestController
public class KafkaPublisherApplication {

    @Autowired
    private KafkaTemplate<String, Object> template;

    public static void main(String[] args) {
        SpringApplication.run(KafkaPublisherApplication.class, args);
    }

}
