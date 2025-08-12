package com.sakithyan.miniproject.E_Commerce.Management.service.serviceimpl;

import com.sakithyan.miniproject.E_Commerce.Management.dao.CustomerDAO;
import com.sakithyan.miniproject.E_Commerce.Management.dto.CustomerDTO;
import com.sakithyan.miniproject.E_Commerce.Management.exception.customerexceptions.CustomerHaventRegisteredException;
import com.sakithyan.miniproject.E_Commerce.Management.exception.customerexceptions.InvalidCredentialsException;
import com.sakithyan.miniproject.E_Commerce.Management.exception.customerexceptions.RegisterAlreadyExistException;
import com.sakithyan.miniproject.E_Commerce.Management.mapper.CustomerMapper;
import com.sakithyan.miniproject.E_Commerce.Management.model.Customer;
import com.sakithyan.miniproject.E_Commerce.Management.service.serviceinterface.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerDAO customerDAO;

    @Autowired
    CustomerMapper customerMapper;

    public CustomerDTO registerCustomer(CustomerDTO customerDTO) {
        if (customerDAO.existsByCustomerUserNameBoolean(customerDTO.getCustomerUserName())) {
            throw new RegisterAlreadyExistException("Registered name already exist with the name: "
                    + customerDTO.getCustomerUserName());
        }

        Customer customer = customerMapper.customerDTOToCustomer(customerDTO);
        Customer saveCustomer = customerDAO.customerRegister(customer);

        return customerMapper.customerToCustomerDTO(saveCustomer);
    }

    public boolean loginCustomer(CustomerDTO customerDTO) {
        if (!customerDAO.existsByCustomerUserNameBoolean(customerDTO.getCustomerUserName())) {
            throw new CustomerHaventRegisteredException("Customer needs to register first! ");
        }

        Customer customer = customerDAO.findByCustomerUserName(customerDTO.getCustomerUserName());

        if (customer.getCustomerPassword().equals(customerDTO.getCustomerPassword())) {
            customerMapper.customerToCustomerDTO(customer);
            return true;
        } else {
            throw new InvalidCredentialsException("Your password is incorrect");
        }
    }

    public CustomerDTO getCustomerByName(String name) {
        Customer customer = customerDAO.findByCustomerUserName(name);
        if (Objects.equals(customer.getCustomerUserName(), name)) {
            return customerMapper.customerToCustomerDTO(customer);
        }
        return null;
    }

    public List<CustomerDTO> getAllCustomer() {
        List<Customer> customerList = customerDAO.getAllCustomer();
        List<CustomerDTO> customerDTOList = new ArrayList<>();

        for (Customer customer : customerList) {
            CustomerDTO customerDTO = customerMapper.customerToCustomerDTO(customer);
            customerDTOList.add(customerDTO);
        }
        return customerDTOList;
    }

    public CustomerDTO updateCustomer(CustomerDTO customerDTO) {
        if (!customerDAO.existsByCustomerUserNameBoolean(customerDTO.getCustomerUserName())) {
            throw new CustomerHaventRegisteredException("Customer needs to register first! ");
        }

        Customer customer = customerMapper.customerDTOToCustomer(customerDTO);
        Customer updateCustomer = customerDAO.customerRegister(customer);

        return customerMapper.customerToCustomerDTO(updateCustomer);
    }

    public CustomerDTO deleteCustomer(CustomerDTO customerDTO) {
        Optional<Customer> optionalCustomer = Optional.ofNullable(customerDAO.findByCustomerUserName(customerDTO.getCustomerUserName()));

        if (optionalCustomer.isEmpty()) {
            throw new CustomerHaventRegisteredException("NO customer exist!");
        }

        Customer customer = optionalCustomer.get();
        Customer deleteCustomer = customerDAO.deleteCustomer(customer);

        return customerMapper.customerToCustomerDTO(deleteCustomer);
    }
}
