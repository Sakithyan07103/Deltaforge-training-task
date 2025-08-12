package com.sakithyan.miniproject.E_Commerce.Management.repo;

import com.sakithyan.miniproject.E_Commerce.Management.model.Customer;
import com.sakithyan.miniproject.E_Commerce.Management.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface OrderRepo extends JpaRepository<Order, Integer> {
        List<Order> findByCustomer(Customer customer);
}
