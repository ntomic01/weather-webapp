package com.example.weatherwebapp.service;

import java.time.LocalDate;

public interface WeatherService {

    void fetchWeatherData();

    void fetchDataByCityAndDate(String cityName, LocalDate localDate);

}
