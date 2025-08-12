    package com.sakithyan.miniproject.E_Commerce.Management.model;

    import jakarta.persistence.*;
    import lombok.AllArgsConstructor;
    import lombok.Data;
    import lombok.NoArgsConstructor;

    import java.util.ArrayList;
    import java.util.List;

    @Entity
    @Data
    @Table(name = "orders")
    @AllArgsConstructor
    @NoArgsConstructor
    public class Order {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int orderId;

        @ManyToOne
        @JoinColumn(name = "customerId")
        private Customer customer;

        @Column(name = "address")
        private String orderShippingAddress;

        @OneToMany(mappedBy = "productOrder", cascade = CascadeType.ALL)
        private List<OrderItems> orderItems = new ArrayList<>();



    }
