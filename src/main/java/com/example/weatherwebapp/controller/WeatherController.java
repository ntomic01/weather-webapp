package com.example.weatherwebapp.controller;

import com.example.weatherwebapp.domain.City;
import com.example.weatherwebapp.domain.dto.response.DailyWeatherResponse;
import com.example.weatherwebapp.domain.dto.response.DayResponse;
import com.example.weatherwebapp.domain.dto.response.WeatherResponse;
import org.apache.catalina.mapper.Mapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/weather")
public class WeatherController {
    private final String apiKey = "e58e1c9ca4b546c0825125407232211";

//    @GetMapping("/city")
//    public ResponseEntity<String> getWeatherForCity(@RequestParam String city){
//        RestTemplate restTemplate = new RestTemplate();
//        String apiUrl = String.format("http://api.weatherapi.com/v1/forecast.json?key=%s&q=%s&days=1&aqi=no&alerts=no",apiKey,city);
//        ResponseEntity<String> response = restTemplate.getForEntity(apiUrl, String.class);
//        return ResponseEntity.ok(response.getBody());
//     }

    @GetMapping("/city")
    public ResponseEntity<DailyWeatherResponse> getWeatherForCity(@RequestParam String city){
        RestTemplate restTemplate = new RestTemplate();
        String apiUrl = String.format("http://api.weatherapi.com/v1/forecast.json?key=%s&q=%s&days=1&aqi=no&alerts=no",apiKey,city);
        ResponseEntity<WeatherResponse> response = restTemplate.getForEntity(apiUrl, WeatherResponse.class);
        WeatherResponse weatherResponse = response.getBody();
        DayResponse dayResponse = weatherResponse.getForecast().getForecastday().get(0).getDay();
        DailyWeatherResponse dailyWeatherResponse = new DailyWeatherResponse();
        // prepisujem iz WeatherResponse u DailyWeatherResponse
        dailyWeatherResponse.setMaxTemp(dayResponse.getMaxTemp());
        dailyWeatherResponse.setMinTemp(dayResponse.getMintemp_c());
        dailyWeatherResponse.setAvgTemp(dayResponse.getAvgtemp_c());
        dailyWeatherResponse.setCity(city);
        return ResponseEntity.ok(dailyWeatherResponse);

    }
}
