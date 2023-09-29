package com.example.weatherwebapp.service;

import com.example.weatherwebapp.domain.City;
import com.example.weatherwebapp.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CityServiceImpl implements CityService{

    @Autowired
    private CityRepository cityRepository;

    @Override
    public List<City> getAll() {
         return cityRepository.findAll();
    }

    @Override
    public void save(City city) {

        if(cityRepository.existsByName(city.getName())){
            System.out.println("City with this name already exists!");
        }

        cityRepository.save(city);
    }
}
