package com.sakithyan.miniproject.E_Commerce.Management.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "order_items")
@NoArgsConstructor
@AllArgsConstructor
public class OrderItems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderItemId;

    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;

    @Column(name = "quantity")
    private int productQuantity;

    @Column(name = "price")
    private int productPrice;

    @ManyToOne
    @JoinColumn(name = "orderId")
    private Order productOrder;

   ;

}
