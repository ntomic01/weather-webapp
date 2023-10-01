package com.example.weatherwebapp.service.impl;

import com.example.weatherwebapp.domain.User;
import com.example.weatherwebapp.domain.dto.request.LoginRequest;
import com.example.weatherwebapp.domain.dto.response.LoginResponse;
import com.example.weatherwebapp.repository.UserRepository;
import com.example.weatherwebapp.service.TokenService;
import com.example.weatherwebapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TokenService tokenService;

    public List<User> getActive(){
        return userRepository.findAll();
    }

    public void save(User user){

        // ova metoda kreira novog usera

        if(userRepository.existsByEmail(user.getEmail())) {
            throw new RuntimeException("User this with email already exists.");
        }
        userRepository.save(user);
    }

    @Override
    public LoginResponse login(LoginRequest loginRequest) {

        // ova metoda loguje postojeceg usera

        User user = userRepository.findByEmailAndPassword(loginRequest.getEmail(), loginRequest.getPassword());

        if(user == null){
           throw new RuntimeException("user not found!");
        }

        String token = tokenService.generate(user);
        System.out.println(token);
        return new LoginResponse(token);

    }

}
