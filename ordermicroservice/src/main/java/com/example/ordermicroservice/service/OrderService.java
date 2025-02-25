package com.example.ordermicroservice.service;
import com.example.ordermicroservice.dto.OrderDTO;
import com.example.ordermicroservice.dto.OrderResponseDTO;
import com.example.ordermicroservice.dto.UserDTO;
import com.example.ordermicroservice.mapper.OrderMapper;
import com.example.ordermicroservice.model.Order;
import com.example.ordermicroservice.repository.OrderRepository;
import com.example.ordermicroservice.userserviceclient.UserServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.Response;
import java.io.IOException;
import java.util.UUID;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderMapper orderMapper;

    private UserServiceClient userServiceClient;

    public OrderService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost:8081/api/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        userServiceClient = retrofit.create(UserServiceClient.class);
    }


    public OrderResponseDTO getOrderById(UUID orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        try {
            Response<UserDTO> response = userServiceClient.getUser(order.getUserId()).execute();
            if (response.isSuccessful() && response.body() != null) {
                return orderMapper.toResponseDTO(order, response.body());
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to fetch user details", e);
        }

        throw new RuntimeException("Failed to fetch user details");
    }

    public OrderDTO createOrder(OrderDTO orderDTO) {
        Order order = orderMapper.toEntity(orderDTO);
        orderRepository.save(order);
        return orderMapper.toDTO(order);
    }
}
