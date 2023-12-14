package com.example.weatherwebapp.domain.dto.response;

import lombok.Data;

@Data
public class DailyWeatherResponse {

//    "day": {
//               "mintemp_c": 3,
//               "avgtemp_c": 5,
//               "maxtemp_c": 6
//    }

    private String city;
    private Long minTemp;
    private Long maxTemp;
    private Long avgTemp;


}
