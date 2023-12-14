package com.example.weatherwebapp.service.impl;

import com.example.weatherwebapp.domain.dto.response.DailyWeatherResponse;
import com.example.weatherwebapp.domain.dto.response.DayResponse;
import com.example.weatherwebapp.domain.dto.response.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherIntegration {

    @Value("${weather.service.api-key}")
    private String apiKey;

    @Autowired
    private RestTemplate restTemplate;

    public DailyWeatherResponse getWeatherForCity(String city){
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
