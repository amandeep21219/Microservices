package com.example.microservices.service;
import com.example.microservices.dto.UserDTO;
import com.example.microservices.entity.User;
import com.example.microservices.mapper.UserMapper;
import com.example.microservices.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;

//    public UserDTO getUserById(UUID userId) {
//        User user = userRepository.findById(userId)
//                .orElseThrow(() -> new RuntimeException("User not found"));
//        return new UserDTO(user.getUserId(), user.getName(), user.getEmail());
//    }


public UserDTO getUserById(UUID id) {
    User user = userRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("User not found"));
    return userMapper.toDTO(user);
}




    public UserDTO createUser(UserDTO userDTO) {
        User user = userMapper.toEntity(userDTO);
        user = userRepository.save(user);

        return userMapper.toDTO(user);
    }




//
//    public UserDTO createUser(UserDTO userDTO) {
//        User user = new User();
//        user.setUserId(userDTO.getUserId());
//        user.setName(userDTO.getName());
//        user.setEmail(userDTO.getEmail());
//        userRepository.save(user);
//        return userDTO;
//    }
}