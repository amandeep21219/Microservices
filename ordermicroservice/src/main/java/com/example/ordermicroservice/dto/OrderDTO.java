package com.example.ordermicroservice.dto;
import lombok.Data;

import java.util.UUID;

@Data
public class OrderDTO {
    private UUID orderId;
    private UUID userId;
    private UUID product;
    private int quantity;
}