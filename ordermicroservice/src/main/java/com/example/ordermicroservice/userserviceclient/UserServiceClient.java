package com.example.ordermicroservice.userserviceclient;
import com.example.ordermicroservice.dto.UserDTO;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.UUID;

public interface UserServiceClient {
    @GET("users/{userId}")
    Call<UserDTO> getUser(@Path("userId") UUID userId);
}


