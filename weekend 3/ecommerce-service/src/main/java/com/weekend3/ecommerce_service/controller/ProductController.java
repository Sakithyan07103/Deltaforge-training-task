package com.weekend3.ecommerce_service.controller;

import com.weekend3.ecommerce_service.dto.ProductDTO;
import com.weekend3.ecommerce_service.model.Product;
import com.weekend3.ecommerce_service.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping("/{productName}/{productPrice}/{stockQuantity}")
    public Product addProduct(@PathVariable String productName,
                              @PathVariable int productPrice, @PathVariable int stockQuantity) {
        return productService.addProduct(productName, productPrice, stockQuantity);
    }

    @GetMapping("")
    public List<ProductDTO> getAllProducts() {
        return productService.getAllProducts();
    }


}
