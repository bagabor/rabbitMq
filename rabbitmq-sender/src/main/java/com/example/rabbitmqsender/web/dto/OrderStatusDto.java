package com.example.rabbitmqsender.web.dto;

import com.example.rabbitmqsender.util.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderStatusDto {
    private OrderDto order;
    private OrderStatus status;
    private String message;
}
