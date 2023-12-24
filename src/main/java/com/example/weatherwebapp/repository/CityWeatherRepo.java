package com.example.weatherwebapp.repository;

import java.time.LocalDate;

import com.example.weatherwebapp.domain.City;
import com.example.weatherwebapp.domain.CityWeather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CityWeatherRepo extends JpaRepository<CityWeather,Long> {

    CityWeather findByCity_NameAndDate(String cityName, LocalDate date);

    @Query("from CityWeather cw where cw.city.name = :cityName and cw.date = :date")
    CityWeather fetchByCityNameAndDate(String cityName, LocalDate date);

}
