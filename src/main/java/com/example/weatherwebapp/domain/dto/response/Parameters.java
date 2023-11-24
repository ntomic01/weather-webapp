package com.example.weatherwebapp.domain.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
public class Parameters {

    private Long maxTemp_c;
    private Long minTemp_c;
    private Long avgTemp_c;
}
