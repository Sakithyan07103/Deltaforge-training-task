package com.weekend3.ecommerce_service.service;

import com.weekend3.ecommerce_service.dto.ProductDTO;
import com.weekend3.ecommerce_service.mapper.ProductMapper;
import com.weekend3.ecommerce_service.model.Product;
import com.weekend3.ecommerce_service.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductServiceImpl {
    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductMapper productMapper;

    public Product addProduct(ProductDTO productDTO) {
        Product product = new Product();
        product.setProductName(productDTO.getProductName());
        product.setProductPrice(productDTO.getProductPrice());
        product.setStockQuantity(productDTO.getStockQuantity());
        return productRepository.save(product);
    }

    public List<ProductDTO> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return productMapper.toProductDTOs(products);
    }
}
