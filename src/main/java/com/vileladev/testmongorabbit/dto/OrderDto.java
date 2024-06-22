package com.vileladev.testmongorabbit.dto;

import com.vileladev.testmongorabbit.entity.Order;

import java.math.BigDecimal;

public record OrderDto(
        Long orderId,
        Long CustomerId,
        BigDecimal total
) {

    public static OrderDto fromEntity(Order order) {
        return new OrderDto(order.getId(), order.getCustomerId(), order.getTotalValue());
    }

}
