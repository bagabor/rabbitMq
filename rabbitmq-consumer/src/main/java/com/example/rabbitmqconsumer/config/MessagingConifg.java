package com.example.rabbitmqconsumer.config;


import lombok.RequiredArgsConstructor;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class MessagingConifg {
    @Bean
    public MessageConverter converter() {
        return new Jackson2JsonMessageConverter();
    }
}
