package com.example.weatherwebapp.service;

import com.example.weatherwebapp.domain.User;
import com.example.weatherwebapp.domain.dto.request.LoginRequest;
import com.example.weatherwebapp.domain.dto.request.RegisterRequest;
import com.example.weatherwebapp.domain.dto.response.LoginResponse;
import com.example.weatherwebapp.domain.dto.response.UserResponse;

import java.util.List;

public interface UserService {

    List<User> getActive();
    void save(User user);
    LoginResponse login(LoginRequest loginRequest);
    UserResponse register(RegisterRequest registarRequest);
    void verifyAccount(String email);
    User findById(Long userId);





}
