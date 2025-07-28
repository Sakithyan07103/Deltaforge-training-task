package com.weekend3.ecommerce_service.dto;

import lombok.Data;

@Data
public class OrderItemDTO {
    private int orderId;
    private int quantity;
}
