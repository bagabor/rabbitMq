package com.example.rabbitmqsender.service;

import com.example.rabbitmqsender.config.RabbitMqConfigProperties;
import com.example.rabbitmqsender.web.dto.OrderDto;
import com.example.rabbitmqsender.web.dto.OrderStatusDto;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import static com.example.rabbitmqsender.util.OrderStatus.IN_PROGRESS;

@Service
@RequiredArgsConstructor
public class OrderPublisher {

    private final RabbitTemplate template;
    private final RabbitMqConfigProperties config;

    public void sendMessage(OrderDto orderDto) {
        OrderStatusDto orderStatusDto = OrderStatusDto.builder()
                .order(orderDto)
                .status(IN_PROGRESS)
                .message("order has been sent to message Queue")
                .build();
        template.convertAndSend(config.getExchangeId(), config.getRoutingKey(), orderStatusDto);
    }
}
