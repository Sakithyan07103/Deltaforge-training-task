package com.weekend3.ecommerce_service.repository;

import com.weekend3.ecommerce_service.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

     boolean  findByCustomerUsernameAndCustomerPassword(String customerUsername, String customerPassword);
}
