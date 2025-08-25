package com.sakithyan.miniproject.E_Commerce.Management.dao;

import com.sakithyan.miniproject.E_Commerce.Management.model.Customer;
import com.sakithyan.miniproject.E_Commerce.Management.model.Product;
import com.sakithyan.miniproject.E_Commerce.Management.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductDAO {
    @Autowired
    ProductRepo productRepo;

    public Product createProduct(Product product) {
        return productRepo.save(product);
    }

    public boolean existsByProductName(String productName) {
        return productRepo.existsByProductName(productName);
    }

    public Product findByProductName(String productName) {
        return productRepo.findByProductName(productName);
    }

    public List<Product> viewAllProducts() {
        return productRepo.findAll();
    }

    public Optional<Product> findProductById(int id) {
        return productRepo.findById(id);
    }

    public Product deleteCustomer(Product product) {
        Product existingProduct = productRepo.findByProductName(product.getProductName());
        if (existingProduct == null) {
            throw new RuntimeException("Customer not found with username: " + product.getProductName());
        }

        productRepo.deleteById(existingProduct.getProductId());
        return existingProduct;
    }
}
