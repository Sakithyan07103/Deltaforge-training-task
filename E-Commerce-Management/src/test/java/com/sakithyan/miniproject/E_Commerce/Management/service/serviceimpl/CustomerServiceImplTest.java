package com.sakithyan.miniproject.E_Commerce.Management.service.serviceimpl;

import com.sakithyan.miniproject.E_Commerce.Management.dao.CustomerDAO;
import com.sakithyan.miniproject.E_Commerce.Management.dto.CustomerDTO;
import com.sakithyan.miniproject.E_Commerce.Management.exception.customerexceptions.CustomerHaventRegisteredException;
import com.sakithyan.miniproject.E_Commerce.Management.exception.customerexceptions.InvalidCredentialsException;
import com.sakithyan.miniproject.E_Commerce.Management.exception.customerexceptions.RegisterAlreadyExistException;
import com.sakithyan.miniproject.E_Commerce.Management.mapper.CustomerMapper;
import com.sakithyan.miniproject.E_Commerce.Management.model.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CustomerServiceImplTest {

    @Mock
    private CustomerDAO customerDAO;

    @Mock
    private CustomerMapper customerMapper;

    @InjectMocks
    private CustomerServiceImpl customerService;

    private CustomerDTO customerDTO;
    private Customer customer;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        customerDTO = new CustomerDTO(1, "testuser", "pass123", "test@mail.com");
        customer = new Customer();
        customer.setCustomerId(1);
        customer.setCustomerUserName("testuser");
        customer.setCustomerPassword("pass123");
        customer.setCustomerEmail("test@mail.com");
    }

    @Test
    void test_RegisterCustomer_Valid() {
        when(customerDAO.existsByCustomerUserNameBoolean("testuser")).thenReturn(false);
        when(customerMapper.customerDTOToCustomer(customerDTO)).thenReturn(customer);
        when(customerDAO.customerRegister(customer)).thenReturn(customer);
        when(customerMapper.customerToCustomerDTO(customer)).thenReturn(customerDTO);

        CustomerDTO result = customerService.registerCustomer(customerDTO);
        assertEquals("testuser", result.getCustomerUserName());
    }

    @Test
    void test_RegisterCustomer_AlreadyExists() {
        when(customerDAO.existsByCustomerUserNameBoolean("testuser")).thenReturn(true);
        assertThrows(RegisterAlreadyExistException.class, () -> customerService.registerCustomer(customerDTO));
    }

    @Test
    void test_LoginCustomer_Valid() {
        when(customerDAO.existsByCustomerUserNameBoolean("testuser")).thenReturn(true);
        when(customerDAO.findByCustomerUserName("testuser")).thenReturn(customer);
        assertTrue(customerService.loginCustomer(customerDTO));
    }

    @Test
    void test_LoginCustomer_NotRegistered() {
        when(customerDAO.existsByCustomerUserNameBoolean("testuser")).thenReturn(false);
        assertThrows(CustomerHaventRegisteredException.class, () -> customerService.loginCustomer(customerDTO));
    }

    @Test
    void test_LoginCustomer_InvalidPassword() {
        when(customerDAO.existsByCustomerUserNameBoolean("testuser")).thenReturn(true);
        customer.setCustomerPassword("wrong");
        when(customerDAO.findByCustomerUserName("testuser")).thenReturn(customer);
        assertThrows(InvalidCredentialsException.class, () -> customerService.loginCustomer(customerDTO));
    }

    @Test
    void test_GetCustomerByName_Found() {
        when(customerDAO.findByCustomerUserName("testuser")).thenReturn(customer);
        when(customerMapper.customerToCustomerDTO(customer)).thenReturn(customerDTO);
        assertNotNull(customerService.getCustomerByName("testuser"));
    }

    @Test
    void test_GetAllCustomer() {
        when(customerDAO.getAllCustomer()).thenReturn(List.of(customer));
        when(customerMapper.customerToCustomerDTO(customer)).thenReturn(customerDTO);
        assertEquals(1, customerService.getAllCustomer().size());
    }

    @Test
    void test_UpdateCustomer_Valid() {
        when(customerDAO.existsByCustomerUserNameBoolean("testuser")).thenReturn(true);
        when(customerMapper.customerDTOToCustomer(customerDTO)).thenReturn(customer);
        when(customerDAO.customerRegister(customer)).thenReturn(customer);
        when(customerMapper.customerToCustomerDTO(customer)).thenReturn(customerDTO);
        assertEquals("testuser", customerService.updateCustomer(customerDTO).getCustomerUserName());
    }

    @Test
    void test_UpdateCustomer_NotRegistered() {
        when(customerDAO.existsByCustomerUserNameBoolean("testuser")).thenReturn(false);
        assertThrows(CustomerHaventRegisteredException.class, () -> customerService.updateCustomer(customerDTO));
    }

    @Test
    void test_DeleteCustomer_Valid() {
        when(customerDAO.findByCustomerUserName("testuser")).thenReturn(customer);
        when(customerDAO.deleteCustomer(customer)).thenReturn(customer);
        when(customerMapper.customerToCustomerDTO(customer)).thenReturn(customerDTO);
        assertNotNull(customerService.deleteCustomer(customerDTO));
    }

    @Test
    void test_DeleteCustomer_NotFound() {
        when(customerDAO.findByCustomerUserName("testuser")).thenReturn(null);
        assertThrows(CustomerHaventRegisteredException.class, () -> customerService.deleteCustomer(customerDTO));
    }
}
