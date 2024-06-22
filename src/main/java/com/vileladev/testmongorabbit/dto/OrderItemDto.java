package com.vileladev.testmongorabbit.dto;

import java.math.BigDecimal;

public record OrderItemDto(String product, Integer quantity, BigDecimal price) {
}
