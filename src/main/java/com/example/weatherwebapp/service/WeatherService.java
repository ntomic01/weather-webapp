package com.example.weatherwebapp.service;

import com.example.weatherwebapp.domain.dto.response.DayResponse;
import com.example.weatherwebapp.domain.dto.response.TemperatureData;

import java.time.LocalDate;

public interface WeatherService {

    void fetchWeatherData();

    TemperatureData fetchDataByCityAndDate(String cityName, LocalDate localDate);

}
