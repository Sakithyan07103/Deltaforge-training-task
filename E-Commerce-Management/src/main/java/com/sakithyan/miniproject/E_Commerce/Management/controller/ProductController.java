package com.sakithyan.miniproject.E_Commerce.Management.controller;

import com.sakithyan.miniproject.E_Commerce.Management.dto.ProductDTO;
import com.sakithyan.miniproject.E_Commerce.Management.service.serviceimpl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductServiceImpl productService;

    @PostMapping("")
    public ProductDTO createProduct(@RequestBody ProductDTO productDTO) {
        return productService.createProduct(productDTO);
    }

    @GetMapping("")
    public List<ProductDTO> viewAllProducts() {
        return productService.viewAllProducts();
    }

    @GetMapping("/{name}")
    public ProductDTO viewProductByName(@PathVariable String name) {
        return productService.viewProductByName(name);
    }

    @PutMapping("")
    public ProductDTO updateProductInfo(@RequestBody ProductDTO productDTO) {
        return productService.updateProductInfo(productDTO);
    }

    @DeleteMapping("")
    public ProductDTO deleteCustomer(@RequestBody ProductDTO productDTO) {
        return productService.deleteCustomer(productDTO);
    }
}
