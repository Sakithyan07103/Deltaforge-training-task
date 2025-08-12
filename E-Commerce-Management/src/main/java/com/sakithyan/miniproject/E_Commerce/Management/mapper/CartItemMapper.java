package com.sakithyan.miniproject.E_Commerce.Management.mapper;

import com.sakithyan.miniproject.E_Commerce.Management.dto.CartDTO;
import com.sakithyan.miniproject.E_Commerce.Management.dto.CartItemDTO;
import com.sakithyan.miniproject.E_Commerce.Management.model.CartItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CartItemMapper {

    @Mapping(source = "product.productId", target = "productId")
    @Mapping(source = "product.productName", target = "productName")
    @Mapping(source = "cartProductQuantity", target = "productQuantity")
    @Mapping(source = "product.productPrice", target = "productPrice")
    @Mapping(source = "productTotalPrice", target = "productTotalPrice")
    CartItemDTO cartItemToCarItemDTO(CartItem cartItem);
    //CartItem cartItemDTOToCartItem(CartItemDTO cartItemDTO);

}
