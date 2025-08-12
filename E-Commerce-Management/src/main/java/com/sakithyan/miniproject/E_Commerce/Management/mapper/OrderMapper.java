package com.sakithyan.miniproject.E_Commerce.Management.mapper;

import com.sakithyan.miniproject.E_Commerce.Management.dto.OrderDTO;
import com.sakithyan.miniproject.E_Commerce.Management.model.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    @Mapping(source = "orderId", target = "orderId  ")
    OrderDTO orderToOrderDTO(Order order);
    Order OrderDTOTOOrder(OrderDTO orderDTO);
}
