package com.example.weatherwebapp.repository;

import com.example.weatherwebapp.domain.CityWeather;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityWeatherRepo extends JpaRepository<CityWeather,Long> {

}
