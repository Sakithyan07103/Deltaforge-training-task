package com.sakithyan.miniproject.E_Commerce.Management.controller;

import com.sakithyan.miniproject.E_Commerce.Management.dto.CustomerDTO;
import com.sakithyan.miniproject.E_Commerce.Management.dto.ProductDTO;
import com.sakithyan.miniproject.E_Commerce.Management.service.serviceimpl.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerServiceImpl customerService;

    @PostMapping("")
    public CustomerDTO registerCustomer(@RequestBody CustomerDTO customerDTO) {
        return customerService.registerCustomer(customerDTO);
    }

    @GetMapping("/login")
    public boolean loginCustomer(@RequestBody CustomerDTO customerDTO) {
        return customerService.loginCustomer(customerDTO);
    }

    @GetMapping("")
    public List<CustomerDTO> getAllCustomer() {
        return customerService.getAllCustomer();
    }

    @GetMapping("/{name}")
    public CustomerDTO getCustomerByName(@PathVariable String name) {
        return customerService.getCustomerByName(name);
    }

    @PutMapping("")
    public CustomerDTO updateCustomer(@RequestBody CustomerDTO customerDTO) {
       return customerService.updateCustomer(customerDTO);
    }

    @DeleteMapping("")
    public CustomerDTO deleteCustomer(@RequestBody CustomerDTO customerDTO) {
        return customerService.deleteCustomer(customerDTO);
    }
}
