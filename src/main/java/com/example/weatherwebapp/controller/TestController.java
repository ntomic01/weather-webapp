package com.example.weatherwebapp.controller;

import com.example.weatherwebapp.domain.User;
import com.example.weatherwebapp.service.UserService;
import com.example.weatherwebapp.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class TestController {
    @Autowired
    private UserService userService;
    @Autowired
    private WeatherService weatherService;

    @GetMapping("/hi")
    public String hi(){
        return "hi";
    }

    @PostMapping("/save")
    public void save(@RequestBody User user){
        userService.save(user);
    }

    @PostMapping("/fetch")
    public void fetchWeatherData(){
        weatherService.fetchWeatherData();
    }






}
