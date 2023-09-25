package com.example.weatherwebapp.service;

import com.example.weatherwebapp.domain.User;

import java.util.List;

public interface UserService {

    List<User> getActive();
    void save(User user);
}
