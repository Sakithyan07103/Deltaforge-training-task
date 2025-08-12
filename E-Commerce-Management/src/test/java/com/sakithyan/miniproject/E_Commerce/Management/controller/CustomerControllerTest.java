package com.sakithyan.miniproject.E_Commerce.Management.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sakithyan.miniproject.E_Commerce.Management.dto.CustomerDTO;
import com.sakithyan.miniproject.E_Commerce.Management.service.serviceimpl.CustomerServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class CustomerControllerTest {

    private MockMvc mockMvc;

    @Mock
    private CustomerServiceImpl customerService;

    private CustomerDTO customerDTO;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        CustomerController controller = new CustomerController();
        controller.customerService = customerService; // manual inject
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

        customerDTO = new CustomerDTO(1, "testuser", "pass123", "test@mail.com");
    }

    @Test
    void test_RegisterCustomer() throws Exception {
        when(customerService.registerCustomer(customerDTO)).thenReturn(customerDTO);

        mockMvc.perform(post("/customer")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(customerDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.customerUserName").value("testuser"));
    }

    @Test
    void test_LoginCustomer() throws Exception {
        when(customerService.loginCustomer(customerDTO)).thenReturn(true);

        mockMvc.perform(get("/customer/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(customerDTO)))
                .andExpect(status().isOk())
                .andExpect(content().string("true"));
    }

    @Test
    void test_GetAllCustomer() throws Exception {
        when(customerService.getAllCustomer()).thenReturn(List.of(customerDTO));

        mockMvc.perform(get("/customer"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].customerUserName").value("testuser"));
    }

    @Test
    void test_GetCustomerByName() throws Exception {
        when(customerService.getCustomerByName("testuser")).thenReturn(customerDTO);

        mockMvc.perform(get("/customer/testuser"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.customerUserName").value("testuser"));
    }

    @Test
    void test_UpdateCustomer() throws Exception {
        when(customerService.updateCustomer(customerDTO)).thenReturn(customerDTO);

        mockMvc.perform(put("/customer")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(customerDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.customerUserName").value("testuser"));
    }

    @Test
    void test_DeleteCustomer() throws Exception {
        when(customerService.deleteCustomer(customerDTO)).thenReturn(customerDTO);

        mockMvc.perform(delete("/customer")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(customerDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.customerUserName").value("testuser"));
    }
}
