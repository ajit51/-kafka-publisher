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
	
	private static final String TOPIC_NAME = "TestTopic";
	
	
	@GetMapping("/publish/{name}")
	public String publisgMessage(@PathVariable String name) {
		template.send(TOPIC_NAME, "Hi "+name+" Welcome to Kafka");
		return "Data Published";
	}
	
	@GetMapping("/publishJson")
	public String publisgMessage() {
		User user = new User(1212, "ABC", new String[] {"Banblore", "Pune", "Mumbai"});
		template.send(TOPIC_NAME, user);
		return "Json Data Published";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(KafkaPublisherApplication.class, args);
	}

}
