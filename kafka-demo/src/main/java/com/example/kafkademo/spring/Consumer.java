package com.example.kafkademo.spring;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class Consumer {

    private final Logger logger = LoggerFactory.getLogger(Producer.class);

    @KafkaListener(topics = "users", groupId = "template_group")
    public void consume(User user) throws IOException {
        logger.info(String.format("#### -> Consumed message -> %s", user.getMessage()));
    }
}
