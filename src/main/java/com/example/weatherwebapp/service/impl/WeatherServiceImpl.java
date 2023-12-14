package com.example.weatherwebapp.service.impl;

import com.example.weatherwebapp.domain.City;
import com.example.weatherwebapp.domain.CityWeather;
import com.example.weatherwebapp.repository.CityRepository;
import com.example.weatherwebapp.repository.CityWeatherRepo;
import com.example.weatherwebapp.service.CityService;
import com.example.weatherwebapp.service.WeatherService;
import org.indigo.dtomapper.providers.specification.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public void FetchWeatherData() {

        List<City> cities = new ArrayList<>();

        
    }
}
