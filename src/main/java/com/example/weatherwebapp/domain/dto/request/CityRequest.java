package com.example.weatherwebapp.domain.dto.request;

import com.example.weatherwebapp.service.impl.UserServiceImpl;
import lombok.Data;

@Data
public class CityRequest {

    private Long cityId;

    private String token;


}
