package com.sakithyan.miniproject.E_Commerce.Management.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "products")
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;

    @Column(name = "name")
    private String productName;

    @Column(name = "description")
    private String productDescription;

    @Column(name = "price")
    private int productPrice;

    @Column(name = "quantity")
    private int productQuantity;
}
