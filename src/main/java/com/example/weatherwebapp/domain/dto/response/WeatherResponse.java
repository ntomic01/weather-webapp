package com.example.weatherwebapp.domain.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WeatherResponse {

//    "forecast": {
//        "forecastday": [
//        {
//            "date": "2023-11-24",
//                "date_epoch": 1700784000,
//                "day": {
//                    "maxtemp_c": 6.3,
//                    "maxtemp_f": 43.3,
//                    "mintemp_c": 3.4,
//                    "mintemp_f": 38.2,
//                    "avgtemp_c": 5.2,

    private ForecastResponse forecast;

    // prvo pravim jedan weatherIntegration servis gde selim metodu iz mog kontrolera da ona vrati DailyWeatherResponse..



}
