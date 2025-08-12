package com.sakithyan.miniproject.E_Commerce.Management.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO{
    private int orderId;
    private List<Integer> productIds;
    private List<Integer> orderQuantities;
    private String orderAddress;

}
