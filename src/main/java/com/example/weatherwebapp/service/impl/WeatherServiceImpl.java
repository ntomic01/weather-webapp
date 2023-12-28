package com.example.weatherwebapp.service.impl;

import com.example.weatherwebapp.controller.TestController;
import com.example.weatherwebapp.domain.City;
import com.example.weatherwebapp.domain.CityWeather;
import com.example.weatherwebapp.domain.dto.response.DailyWeatherResponse;
import com.example.weatherwebapp.domain.dto.response.TemperatureData;
import com.example.weatherwebapp.repository.CityRepository;
import com.example.weatherwebapp.repository.CityWeatherRepo;
import com.example.weatherwebapp.service.CityService;
import com.example.weatherwebapp.service.WeatherService;
import org.indigo.dtomapper.providers.specification.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class WeatherServiceImpl implements WeatherService {
    @Autowired
    private Mapper mapper;
    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private CityWeatherRepo cityWeatherRepo;
    @Autowired
    private WeatherIntegration weatherIntegration;

    @Override
    public void fetchWeatherData() {
        // korak 1. dovucem sve gradove iz baze(CityRepository)
        List<City> cities = cityRepository.findAll();
        // korak 2. povucem vremensku prognozu za svaki grad
        for (City city : cities) {
            DailyWeatherResponse dailyWeatherResponse = weatherIntegration.getWeatherForCity(city.getName());
            // korak 3. sacuvam CityWeather za svaki grad i datum.
            CityWeather cityWeather = new CityWeather();
            cityWeather.setCity(city);
            cityWeather.setDate(LocalDate.now());
            cityWeather.setMinTemp(dailyWeatherResponse.getMinTemp());
            cityWeather.setMaxTemp(dailyWeatherResponse.getMaxTemp());
            cityWeather.setAvgTemp(dailyWeatherResponse.getAvgTemp());
            cityWeatherRepo.save(cityWeather);
        }

        // korak 4. napravim neki testController i probam

    }

    @Override
    public TemperatureData fetchDataByCityAndDate(String cityName, LocalDate localDate) {

        CityWeather cw = cityWeatherRepo.findByCity_NameAndDate(cityName, localDate);
        TemperatureData temperature = new TemperatureData();
        temperature.setMinTemp(cw.getMinTemp());
        temperature.setMaxTemp(cw.getMaxTemp());
        temperature.setAvgTemp(cw.getAvgTemp());
        System.out.println(temperature);

        return mapper.map(temperature, TemperatureData.class);

    }





}




