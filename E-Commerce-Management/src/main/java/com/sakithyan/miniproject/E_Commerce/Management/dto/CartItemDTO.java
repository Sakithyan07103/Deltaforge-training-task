package com.sakithyan.miniproject.E_Commerce.Management.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartItemDTO {
    private int productId;
    private String productName;
    private int productQuantity;
    private double productPrice;
    private double productTotalPrice;
}
