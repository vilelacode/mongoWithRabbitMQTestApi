package com.vileladev.testmongorabbit.dto;

import com.vileladev.testmongorabbit.entity.OrderItem;

import java.util.List;

public record OrderCreatedDto(Long orderNumber,
                             Long customerId,
                             List<OrderItem> items) {
}

