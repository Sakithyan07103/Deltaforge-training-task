package com.sakithyan.miniproject.E_Commerce.Management.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    private String productName;
    private String productDescription;
    private int productPrice;
    private int productQuantity;
}
