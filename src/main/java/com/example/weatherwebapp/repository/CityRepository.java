package com.example.weatherwebapp.repository;

import com.example.weatherwebapp.domain.City;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City,String> {
    boolean existsByName(String name);

}
