package com.example.weatherwebapp.service;

import com.example.weatherwebapp.domain.City;

import java.util.List;

public interface CityService {

    List<City> getAll();
    void save(City city);
}
