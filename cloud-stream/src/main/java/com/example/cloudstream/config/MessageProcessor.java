package com.example.cloudstream.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
public class MessageProcessor {

    @Bean
    public Function<String, String> processor() {
        return (msg) -> {
            System.out.println("Prining from Processor");
            return msg.toUpperCase()+" : Message is processed";
        };
    }
}
