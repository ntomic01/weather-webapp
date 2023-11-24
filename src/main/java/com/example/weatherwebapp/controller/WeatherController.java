package com.example.weatherwebapp.controller;

import com.example.weatherwebapp.domain.City;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/weather")
public class WeatherController {
    private final String apiKey = "e58e1c9ca4b546c0825125407232211";

    @GetMapping("/city")
    public ResponseEntity<String> getWeatherForCity(@PathVariable String city){
        RestTemplate restTemplate = new RestTemplate();
        String apiUrl = "https://api.weatherapi.com/forecast?city=" + city + "&key=" + apiKey;
        ResponseEntity<String> response = restTemplate.getForEntity(apiUrl, String.class);
        return ResponseEntity.ok(response.getBody());
     }
}
