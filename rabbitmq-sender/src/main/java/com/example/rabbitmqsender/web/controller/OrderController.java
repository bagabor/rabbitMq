package com.example.rabbitmqsender.web.controller;


import com.example.rabbitmqsender.service.OrderPublisher;
import com.example.rabbitmqsender.web.dto.OrderDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static java.util.UUID.randomUUID;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderPublisher orderPublisher;

    @PostMapping
    public ResponseEntity bookOrder(@RequestBody OrderDto orderDto) {
        orderDto.setOrderId(randomUUID());
        orderPublisher.sendMessage(orderDto);
        return ResponseEntity.ok().build();
    }
}
