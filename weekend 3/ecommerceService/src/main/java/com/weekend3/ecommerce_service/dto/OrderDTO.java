package com.weekend3.ecommerce_service.dto;

import lombok.Data;
import java.util.List;

@Data
public class OrderDTO {
    private int orderId;
    private int customerId;
    private List<OrderDTO> orderItems;
}
