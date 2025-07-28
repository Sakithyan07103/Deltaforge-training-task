package com.weekend3.ecommerce_service.dto;

import lombok.Data;

@Data
public class CartItemDTO {
    private int cartId;
    private int productId;
    private int customerId;
    private int quantity;
}
