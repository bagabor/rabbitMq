package com.example.rabbitmqsender.config;


import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class MessagingConifg {

    private final RabbitMqConfigProperties rabbitMqConfigProperties;

    @Bean
    public Queue queue() {
        return new Queue(rabbitMqConfigProperties.getQueueName());
    }

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(rabbitMqConfigProperties.getExchangeId());
    }

    @Bean
    public Binding binding(Queue queue, TopicExchange exchange) {
        // with means every message that starts with...
        return BindingBuilder.bind(queue).to(exchange).with(rabbitMqConfigProperties.getRoutingKey());
    }

    @Bean
    public MessageConverter converter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate template(ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(converter());
        return rabbitTemplate;
    }
}
