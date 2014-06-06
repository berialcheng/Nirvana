package org.nirvana;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class SampleApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SampleApplication.class, args);
    }
}