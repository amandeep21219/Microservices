package com.example.ordermicroservice.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class OrderResponseDTO {
    private UUID orderId;
    private UserDTO user;
    private UUID product;
    private int quantity;
}