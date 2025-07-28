package com.weekend3.ecommerce_service.mapper;

import com.weekend3.ecommerce_service.dto.ProductDTO;
import com.weekend3.ecommerce_service.model.Product;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductDTO toproductDTO(Product product);

    List<ProductDTO> toProductDTOs(List<Product> products);
}
