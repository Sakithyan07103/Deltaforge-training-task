package com.weekend3.ecommerce_service.service.serviceInterface;

import com.weekend3.ecommerce_service.dto.ProductDTO;
import com.weekend3.ecommerce_service.model.Product;
import java.util.List;

public interface ProductService {
     Product addProduct(ProductDTO productDTO);

     List<ProductDTO> getAllProducts();
}
