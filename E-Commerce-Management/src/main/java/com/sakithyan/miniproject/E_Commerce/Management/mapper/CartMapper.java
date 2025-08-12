package com.sakithyan.miniproject.E_Commerce.Management.mapper;

import com.sakithyan.miniproject.E_Commerce.Management.dto.CartDTO;
import com.sakithyan.miniproject.E_Commerce.Management.dto.CartItemDTO;
import com.sakithyan.miniproject.E_Commerce.Management.dto.CustomerDTO;
import com.sakithyan.miniproject.E_Commerce.Management.model.Cart;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring", uses = {CartItemMapper.class})
public interface CartMapper {

    @Mapping(source = "cartId", target = "cartId")
    @Mapping(source = "customer.customerId", target = "customerId")
    @Mapping(source = "cartItems", target = "cartItems")
    CartDTO cartToCarDTO(Cart cart);

    @InheritInverseConfiguration
    Cart cartDTOToCart(CartDTO cartDTO);

}
