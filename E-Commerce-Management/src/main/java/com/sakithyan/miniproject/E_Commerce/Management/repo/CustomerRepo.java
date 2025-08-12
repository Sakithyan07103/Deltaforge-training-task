package com.sakithyan.miniproject.E_Commerce.Management.repo;

import com.sakithyan.miniproject.E_Commerce.Management.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {
     boolean existsByCustomerUserName(String customerUserName);
     Customer findByCustomerUserName(String customerUserName);
}
