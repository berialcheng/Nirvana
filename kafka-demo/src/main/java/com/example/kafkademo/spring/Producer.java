package com.example.kafkademo.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {
    private static final Logger logger = LoggerFactory.getLogger(Producer.class);

    @Autowired
    private KafkaTemplate<String, User> kafkaTemplate;

    public void sendMessage(String topic, String message) {
        logger.info(String.format("#### -> Producing message -> %s", message));
        this.kafkaTemplate.send(topic, new User.Builder().name("rest producer").message(message).build());
    }
}
