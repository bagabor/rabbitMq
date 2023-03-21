package com.example.cloudstream.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Configuration
public class MessageConsumer {

    @Bean
    public Consumer<String> consumer() {
        return (msg) -> {
            System.out.println("Received the message in Consumer :"+msg);
        };
    }
}
