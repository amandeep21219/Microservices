package com.example.ordermicroservice.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;
@Data
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID orderId;
    @Column
    private UUID userId;
    @Column
    private UUID product;
    @Column
    private int quantity;
}