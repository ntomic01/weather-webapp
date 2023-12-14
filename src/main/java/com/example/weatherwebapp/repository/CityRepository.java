package com.example.weatherwebapp.repository;

import com.example.weatherwebapp.domain.City;
import com.example.weatherwebapp.domain.CityWeather;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CityRepository extends JpaRepository<City,String> {
    boolean existsByName(String name);
    List<City> findAll();


}
