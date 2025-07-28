package com.weekend3.ecommerce_service.dto;

import lombok.Data;

@Data
public class CartItemDTO {
    private int productId;
    private int quantity;
}
