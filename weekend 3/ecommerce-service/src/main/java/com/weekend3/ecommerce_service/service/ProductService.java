package com.weekend3.ecommerce_service.service;

import com.weekend3.ecommerce_service.dto.ProductDTO;
import com.weekend3.ecommerce_service.mapper.ProductMapper;
import com.weekend3.ecommerce_service.model.Product;
import com.weekend3.ecommerce_service.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductMapper productMapper;

    public Product addProduct(String productName, int productPrice, int stockQuantity) {
        Product product = new Product();
        product.setProductName(productName);
        product.setProductPrice(productPrice);
        product.setStockQuantity(stockQuantity);
        return productRepository.save(product);
    }

    public List<ProductDTO> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return productMapper.toProductDTOs(products);
    }
}
