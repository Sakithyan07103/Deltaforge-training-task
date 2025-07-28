package com.weekend3.ecommerce_service.controller;

import com.weekend3.ecommerce_service.dto.ProductDTO;
import com.weekend3.ecommerce_service.model.Product;
import com.weekend3.ecommerce_service.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductServiceImpl productService;

    @PostMapping("")
    public Product addProduct(@RequestBody ProductDTO productDTO) {
        return productService.addProduct(productDTO);
    }

    @GetMapping("")
    public List<ProductDTO> getAllProducts() {
        return productService.getAllProducts();
    }


}
