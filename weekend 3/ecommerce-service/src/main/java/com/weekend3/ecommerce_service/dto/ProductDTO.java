package com.weekend3.ecommerce_service.dto;

import lombok.Data;

@Data
public class ProductDTO {
    private int productId;
    private String productName;
    private double productPrice;
    private int stockQuantity;

}
