package com.example.weatherwebapp.controller;

import com.example.weatherwebapp.domain.User;
import com.example.weatherwebapp.domain.dto.request.LoginRequest;
import com.example.weatherwebapp.domain.dto.request.RegisterRequest;
import com.example.weatherwebapp.domain.dto.response.LoginResponse;
import com.example.weatherwebapp.domain.dto.response.UserResponse;
import com.example.weatherwebapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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
    public UserResponse register(@RequestBody RegisterRequest registerRequest){
        return userService.register(registerRequest);
    }

    @GetMapping("/verifyAccount")
    public ResponseEntity<String> verify(@RequestParam String email) {
        userService.verifyAccount(email);
        return ResponseEntity.ok("Verifikacija uspešna!");
    }

    @GetMapping("/verify")
    public ModelAndView verifyAccount(@RequestParam("userId") Long userId) {
        User user = userService.findById(userId);

        if (user != null) {
//            user.setVerified(true);
            userService.save(user);
            return new ModelAndView("verification_success"); // Prikazuje se stranica sa porukom o uspešnoj verifikaciji.
        } else {
            return new ModelAndView("verification_error"); // Prikazuje se stranica sa porukom o grešci u verifikaciji.
        }
    }
    @GetMapping("/register")
    public String register(){
        return "register";
    }



}
