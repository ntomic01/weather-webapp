package com.example.weatherwebapp.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "weathers")
public class CityWeather {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long minTemp;
    private Long maxTemp;
    private Long avgTemp;
    private LocalDateTime createdAt = LocalDateTime.now();
    @ManyToOne
    @JoinColumn(name = "city_id")
    @ToString.Exclude
    private City city;




}
