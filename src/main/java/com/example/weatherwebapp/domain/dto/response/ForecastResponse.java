package com.example.weatherwebapp.domain.dto.response;

import lombok.Data;

import java.util.List;

@Data
public class ForecastResponse {

//    "forecastday": [
////        {
////            "date": "2023-11-24",
////                "date_epoch": 1700784000,
////                "day": {
////                    "maxtemp_c": 6.3,
////                    "maxtemp_f": 43.3,
////                    "mintemp_c": 3.4,
////                    "mintemp_f": 38.2,
////                    "avgtemp_c": 5.2,

    private List<ForecastDayResponse> forecastday;

}
