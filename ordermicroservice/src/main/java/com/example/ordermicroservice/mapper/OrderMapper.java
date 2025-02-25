package com.example.ordermicroservice.mapper;
import com.example.ordermicroservice.dto.OrderDTO;
import com.example.ordermicroservice.dto.OrderResponseDTO;
import com.example.ordermicroservice.dto.UserDTO;
import com.example.ordermicroservice.model.Order;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;


@Component
public class OrderMapper {

    private final ModelMapper modelMapper;

    // 🔹 Constructor Injection to ensure ModelMapper is initialized
    public OrderMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Order toEntity(OrderDTO orderDTO) {
        return modelMapper.map(orderDTO, Order.class);
    }

    public OrderDTO toDTO(Order order) {
        return modelMapper.map(order, OrderDTO.class);
    }

    public OrderResponseDTO toResponseDTO(Order order, UserDTO user) {
        OrderResponseDTO responseDTO = modelMapper.map(order, OrderResponseDTO.class);
        responseDTO.setUser(user);
        return responseDTO;
    }
}