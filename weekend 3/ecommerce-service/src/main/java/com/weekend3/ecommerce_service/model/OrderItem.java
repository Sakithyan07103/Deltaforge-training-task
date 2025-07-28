package com.weekend3.ecommerce_service.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "order_iitem")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderItemId;
    @ManyToOne
    @JoinColumn(name = "orderId")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;

    private int quantity;
}
