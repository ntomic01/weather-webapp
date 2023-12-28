package com.example.weatherwebapp.domain.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDate;

@Data
public class DayResponse {
    @JsonProperty("maxtemp_c")
    private Long maxTemp;
    private Long mintemp_c;
    private Long avgtemp_c;

}
