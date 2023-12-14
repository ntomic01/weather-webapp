package com.example.weatherwebapp.service;

import com.example.weatherwebapp.domain.City;

public interface WeatherService {

    void FetchWeatherData();

    // korak 1. dovucem sve gradove iz baze(CityRepository)
    // korak 2. povucem vremensku prognozu za svaki grad
    // korak 3. sacuvam CityWeather za svaki grad i datum.
    // korak 4. napravim neki testController i probam

}
