package com.sakithyan.miniproject.E_Commerce.Management.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Entity
@Table(name = "customers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerId;

    @Column(name = "username", unique = true)
    private String customerUserName;

    @Column(name = "password", unique = true)
    private String customerPassword;

    @Column(name = "Email")
    private String customerEmail;
}
