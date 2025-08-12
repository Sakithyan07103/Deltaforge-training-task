package com.sakithyan.miniproject.E_Commerce.Management.dto;

import lombok.Data;
import java.util.List;

@Data
public class CartDTO {
    private int cartId;
    private int customerId;
    private List<CartItemDTO> cartItems;
    private double totalPrice;
}
