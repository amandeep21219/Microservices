package com.example.ordermicroservice.dto;

import lombok.Data;
import java.util.UUID;
@Data
public class UserDTO {
    private UUID userId;
    private String name;
    private String email;

}