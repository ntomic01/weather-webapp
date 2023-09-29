package com.example.weatherwebapp.service.impl;

import com.example.weatherwebapp.domain.User;
import com.example.weatherwebapp.repository.UserRepository;
import com.example.weatherwebapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getActive(){
        return userRepository.findAll();
    }

    public void save(User user){

        if(userRepository.existsByEmail(user.getEmail())) {
            throw new RuntimeException("User this with email already exists.");
        }
        userRepository.save(user);
    }



}
