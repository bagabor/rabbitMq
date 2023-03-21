package com.example.rabbitmqconsumer.web.dto;

import com.example.rabbitmqconsumer.util.OrderStatus;
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
