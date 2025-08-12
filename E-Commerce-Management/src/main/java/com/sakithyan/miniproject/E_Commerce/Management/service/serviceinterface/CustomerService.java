package com.sakithyan.miniproject.E_Commerce.Management.service.serviceinterface;

import com.sakithyan.miniproject.E_Commerce.Management.dto.CustomerDTO;

public interface CustomerService {
    public CustomerDTO registerCustomer(CustomerDTO customerDTO);
    public boolean loginCustomer(CustomerDTO customerDTO);
    public CustomerDTO updateCustomer(CustomerDTO customerDTO);
    public CustomerDTO deleteCustomer(CustomerDTO customerDTO);
}
