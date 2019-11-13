package com.example.kafkademo.basic.raw;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class KafkaController {

    @GetMapping(value = "/publish")
    public void publish(){

    }
}
