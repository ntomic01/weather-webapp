package com.example.weatherwebapp.domain.dto.response;

import com.example.weatherwebapp.domain.City;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TemperatureData {

    private String cityName;
    private Long minTemp;
    private Long maxTemp;
    private Long avgTemp;

}
