package com.example.ordermicroservice.controller;
import com.example.ordermicroservice.dto.OrderDTO;
import com.example.ordermicroservice.dto.OrderResponseDTO;
import com.example.ordermicroservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api/v1/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public OrderDTO createOrder(@RequestBody OrderDTO orderDTO) {
        return orderService.createOrder(orderDTO);
    }

    @GetMapping("/{orderId}")
    public OrderResponseDTO getOrder(@PathVariable UUID orderId) {
        return orderService.getOrderById(orderId);
    }
}
