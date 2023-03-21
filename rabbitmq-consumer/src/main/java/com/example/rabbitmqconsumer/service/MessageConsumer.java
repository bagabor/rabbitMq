package com.example.rabbitmqconsumer.service;

import com.example.rabbitmqconsumer.web.dto.OrderStatusDto;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class MessageConsumer {

    @RabbitListener(queues = "messageQueueName")
    public void consumerMessageFromQueue(OrderStatusDto orderStatusDto) {
        System.out.println(String.format("Message has been consumed from queue:  {%s}", orderStatusDto));
    }
}
