package com.sakithyan.miniproject.E_Commerce.Management.dao;

import com.sakithyan.miniproject.E_Commerce.Management.exception.customerexceptions.InvalidCredentialsException;
import com.sakithyan.miniproject.E_Commerce.Management.model.Customer;
import com.sakithyan.miniproject.E_Commerce.Management.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CustomerDAO {
    @Autowired
    CustomerRepo customerRepo;

    public Customer customerRegister(Customer customer) {
        if (customer.getCustomerUserName().length() > 2 && customer.getCustomerPassword().length() > 3 && customer.getCustomerEmail().contains("@")  ) {
            return customerRepo.save(customer);
        }
        throw new InvalidCredentialsException("check your credential and fill it acoordingly");
    }

    public boolean existsByCustomerUserNameBoolean(String customerUserName) {
        return customerRepo.existsByCustomerUserName(customerUserName);
    }

    public List<Customer> getAllCustomer() {
        return customerRepo.findAll();
    }

    public Optional<Customer> getCustomer(int id) {
        return customerRepo.findById(id);
    }

    public Customer findByCustomerUserName(String customerUserName) {
        return customerRepo.findByCustomerUserName(customerUserName);
    }

    public Optional<Customer> findById(int id) {
        return customerRepo.findById(id);
    }

    public Customer deleteCustomer(Customer customer) {
        Customer existingCustomer = customerRepo.findByCustomerUserName(customer.getCustomerUserName());
        if (existingCustomer == null) {
            throw new RuntimeException("Customer not found with username: " + customer.getCustomerUserName());
        }
       customerRepo.deleteById(existingCustomer.getCustomerId());
       return existingCustomer;
    }
}

