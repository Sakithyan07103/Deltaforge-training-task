package com.weekend3.ecommerce_service.dto;

import lombok.Data;
import java.util.List;

@Data
public class CartDTO {
    private int cartId;
    private int customerId;
    private List<CustomerDTO> cartItems;
}
