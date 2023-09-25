package com.example.weatherwebapp.service;

import com.example.weatherwebapp.domain.User;
import com.example.weatherwebapp.repository.UserRepository;
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
            throw new RuntimeException("user vec postoji s tim mejlom");
        }
        userRepository.save(user);
    }



}
