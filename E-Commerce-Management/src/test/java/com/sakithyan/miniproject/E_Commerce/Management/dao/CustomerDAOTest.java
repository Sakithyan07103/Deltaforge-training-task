package com.sakithyan.miniproject.E_Commerce.Management.dao;

import com.sakithyan.miniproject.E_Commerce.Management.exception.customerexceptions.InvalidCredentialsException;
import com.sakithyan.miniproject.E_Commerce.Management.model.Customer;
import com.sakithyan.miniproject.E_Commerce.Management.repo.CustomerRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CustomerDAOTest {

    @Mock
    private CustomerRepo customerRepo;

    @InjectMocks
    private CustomerDAO customerDAO;

    private Customer customer;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        customer = new Customer();
        customer.setCustomerId(1);
        customer.setCustomerUserName("testuser");
        customer.setCustomerPassword("pass123");
        customer.setCustomerEmail("test@mail.com");
    }

    @Test
    void test_CustomerRegister_Valid() {
        when(customerRepo.save(customer)).thenReturn(customer);
        Customer result = customerDAO.customerRegister(customer);
        assertEquals("testuser", result.getCustomerUserName());
    }

    @Test
    void test_CustomerRegister_Invalid() {
        customer.setCustomerPassword("p");
        assertThrows(InvalidCredentialsException.class, () -> customerDAO.customerRegister(customer));
    }

    @Test
    void test_ExistsByCustomerUserNameBoolean() {
        when(customerRepo.existsByCustomerUserName("test")).thenReturn(true);
        assertTrue(customerDAO.existsByCustomerUserNameBoolean("test"));
    }

    @Test
    void test_GetAllCustomer() {
        when(customerRepo.findAll()).thenReturn(List.of(customer));
        assertEquals(1, customerDAO.getAllCustomer().size());
    }

    @Test
    void test_GetCustomer() {
        when(customerRepo.findById(1)).thenReturn(Optional.of(customer));
        assertTrue(customerDAO.getCustomer(1).isPresent());
    }

    @Test
    void test_FindByCustomerUserName() {
        when(customerRepo.findByCustomerUserName("testuser")).thenReturn(customer);
        assertNotNull(customerDAO.findByCustomerUserName("testuser"));
    }

    @Test
    void test_DeleteCustomer_Valid() {
        when(customerRepo.findByCustomerUserName("testuser")).thenReturn(customer);
        doNothing().when(customerRepo).deleteById(1);
        Customer deleted = customerDAO.deleteCustomer(customer);
        assertEquals(1, deleted.getCustomerId());
    }

    @Test
    void test_DeleteCustomer_NotFound() {
        when(customerRepo.findByCustomerUserName("testuser")).thenReturn(null);
        assertThrows(RuntimeException.class, () -> customerDAO.deleteCustomer(customer));
    }
}
