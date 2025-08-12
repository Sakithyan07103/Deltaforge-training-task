package com.sakithyan.miniproject.E_Commerce.Management.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cart_items")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cartItemId;

    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;

    @Column(name = "qty")
    private Integer cartProductQuantity;

    @Column(name = "price")
    private Double productTotalPrice;

    @ManyToOne
    @JoinColumn(name = "cartId")
    private Cart cart;


}
