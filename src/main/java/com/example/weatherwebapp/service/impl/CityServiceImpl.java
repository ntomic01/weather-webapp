package com.example.weatherwebapp.service.impl;

import com.example.weatherwebapp.domain.City;
import com.example.weatherwebapp.repository.CityRepository;
import com.example.weatherwebapp.service.CityService;
import org.indigo.dtomapper.providers.specification.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private Mapper mapper;

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
