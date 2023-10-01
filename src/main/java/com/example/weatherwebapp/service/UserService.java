package com.example.weatherwebapp.service;

import com.example.weatherwebapp.domain.User;
import com.example.weatherwebapp.domain.dto.request.LoginRequest;
import com.example.weatherwebapp.domain.dto.response.LoginResponse;

import java.util.List;

public interface UserService {

    List<User> getActive();
    void save(User user);
    LoginResponse login(LoginRequest loginRequest);
}
