package com.sakithyan.miniproject.E_Commerce.Management.mapper;

import com.sakithyan.miniproject.E_Commerce.Management.dto.ProductDTO;
import com.sakithyan.miniproject.E_Commerce.Management.model.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductDTO productToProductDTO(Product product);
    Product productDTOToProduct(ProductDTO productDTO);
}
