package com.example.weatherwebapp.controller;

import com.example.weatherwebapp.domain.User;
import com.example.weatherwebapp.domain.dto.request.LoginRequest;
import com.example.weatherwebapp.domain.dto.request.RegisterRequest;
import com.example.weatherwebapp.domain.dto.response.LoginResponse;
import com.example.weatherwebapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/authorize")
public class AuthorizationController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest loginRequest){
        return userService.login(loginRequest);
    }

    @PostMapping("/register")
    public User register(@RequestBody RegisterRequest registerRequest){
        return userService.register(registerRequest);
    }

    @GetMapping("/verifyAccount")
    public ResponseEntity<String> verify(@RequestParam String email) {
        User user = userService.verifyAccount(email);
        return ResponseEntity.ok("Verifikacija uspešna!");
    }



}
