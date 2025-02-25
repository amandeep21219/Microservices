package com.example.microservices.controller;
import com.example.microservices.dto.UserDTO;
import com.example.microservices.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public UserDTO createUser(@RequestBody UserDTO userDTO) {
        return userService.createUser(userDTO);
    }

    @GetMapping("/{userId}")
    public UserDTO getUser(@PathVariable UUID userId) {
        return userService.getUserById(userId);
    }
}
