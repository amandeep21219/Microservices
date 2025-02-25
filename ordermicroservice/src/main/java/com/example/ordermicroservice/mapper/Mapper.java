package com.example.ordermicroservice.mapper;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Mapper {  // 🔹 Rename to avoid conflicts
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}