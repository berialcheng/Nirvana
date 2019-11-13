package com.example.kafkademo.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {

    private final Logger logger = LoggerFactory.getLogger(Consumer.class);

    @KafkaListener(topics = "users", groupId = "template_group")
    public void consume(User user) {
        logger.info(String.format("#### -> Consumed message -> %s : %s", user.getName(), user.getMessage()));
    }

    @KafkaListener(topics = "users2", groupId = "template2_group")
    public void consume2(User user) {
        logger.info(String.format("#### -> Consumed message -> %s : %s", user.getName(), user.getMessage()));
    }
}
