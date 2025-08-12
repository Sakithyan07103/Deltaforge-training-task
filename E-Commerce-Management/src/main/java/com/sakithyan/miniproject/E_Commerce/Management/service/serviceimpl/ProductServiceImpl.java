package com.sakithyan.miniproject.E_Commerce.Management.service.serviceimpl;

import com.sakithyan.miniproject.E_Commerce.Management.dao.ProductDAO;
import com.sakithyan.miniproject.E_Commerce.Management.dto.CustomerDTO;
import com.sakithyan.miniproject.E_Commerce.Management.dto.ProductDTO;
import com.sakithyan.miniproject.E_Commerce.Management.exception.customerexceptions.CustomerHaventRegisteredException;
import com.sakithyan.miniproject.E_Commerce.Management.exception.productexceptions.ProductAlreadyExistException;
import com.sakithyan.miniproject.E_Commerce.Management.exception.productexceptions.ProductDoesNotExistException;
import com.sakithyan.miniproject.E_Commerce.Management.mapper.CustomerMapper;
import com.sakithyan.miniproject.E_Commerce.Management.mapper.ProductMapper;
import com.sakithyan.miniproject.E_Commerce.Management.model.Customer;
import com.sakithyan.miniproject.E_Commerce.Management.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProductServiceImpl  {

    @Autowired
    ProductDAO productDAO;

    @Autowired
    ProductMapper productMapper;

    public ProductDTO createProduct(ProductDTO productDTO) {
        System.out.println("mapped dto: " + productDTO);
        if (productMapper == null) {
            throw new RuntimeException("ProductMapper is NULL. It was not injected!");
        }

        if (productDAO.existsByProductName(productDTO.getProductName())) {
            throw new ProductAlreadyExistException("This product already exist! ");
        }

        Product product = productMapper.productDTOToProduct(productDTO);
        System.out.println("mapped dto: " + product.toString());
        Product saveProduct = productDAO.createProduct(product);

        ProductDTO resultDTO = productMapper.productToProductDTO(saveProduct);

        System.out.println("mapped dto: " + resultDTO);

        return resultDTO;
    }

    public List<ProductDTO> viewAllProducts() {
        List<Product> productList = productDAO.viewAllProducts();
        List<ProductDTO> productDTOList = new ArrayList<>();

        for (Product product : productList) {
            ProductDTO productDTO = productMapper.productToProductDTO(product);
            productDTOList.add(productDTO);
        }
        return productDTOList;
    }

    public ProductDTO viewProductByName(String name) {
        Product product = productDAO.findByProductName(name);

        if (Objects.equals(product.getProductName(), name)) {
            return productMapper.productToProductDTO(product);
        }
        return null;
    }

    public ProductDTO updateProductInfo(ProductDTO productDTO) {
        if (!productDAO.existsByProductName(productDTO.getProductName())) {
            throw new ProductDoesNotExistException("This product does not exist here!");
        }

        Product product = productMapper.productDTOToProduct(productDTO);
        Product updateProduct = productDAO.createProduct(product);

        return productMapper.productToProductDTO(updateProduct);
    }

    public ProductDTO deleteCustomer(ProductDTO productDTO) {
        Optional<Product> optionalProduct = Optional.ofNullable(productDAO.findByProductName(productDTO.getProductName()));

        if (optionalProduct.isPresent()) {
            throw new ProductDoesNotExistException("NO product exist!");
        }

        Product product = optionalProduct.get();
        Product deleteProduct = productDAO.deleteCustomer(product);

        return productMapper.productToProductDTO(deleteProduct);
    }

}
