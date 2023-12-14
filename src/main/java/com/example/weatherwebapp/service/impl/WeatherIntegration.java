package com.example.weatherwebapp.service.impl;

import com.example.weatherwebapp.domain.dto.response.DailyWeatherResponse;
import com.example.weatherwebapp.domain.dto.response.DayResponse;
import com.example.weatherwebapp.domain.dto.response.Parameters;
import com.example.weatherwebapp.domain.dto.response.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Service
public class WeatherIntegration {
    @Autowired
    private RestTemplate restTemplate;

    private final String apiKey = "e58e1c9ca4b546c0825125407232211";

    public DailyWeatherResponse getWeatherForCity(String city){
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
        return dailyWeatherResponse;

    }


}
