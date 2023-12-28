package com.example.weatherwebapp.controller;

import java.time.LocalDate;

import com.example.weatherwebapp.domain.User;
import com.example.weatherwebapp.domain.dto.response.TemperatureData;
import com.example.weatherwebapp.service.UserService;
import com.example.weatherwebapp.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
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

    // metoda koja vraca info o temp za grad i datum
    // /user/fetchWeatherData?cityName=Belgrade&date=2023-12-25
    @GetMapping("/fetchWeatherData")
    public TemperatureData fetchWeatherData(@RequestParam String cityName, LocalDate localDate) {
        return weatherService.fetchDataByCityAndDate(cityName,localDate);
    }



}
