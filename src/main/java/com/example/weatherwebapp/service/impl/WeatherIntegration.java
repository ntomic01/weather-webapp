package com.example.weatherwebapp.service.impl;

import com.example.weatherwebapp.domain.dto.response.Parameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Service
public class WeatherIntegration {
    @Autowired
    private RestTemplate restTemplate;

    public Map<String, List<Parameters>> getParameters() {
        try {
            // iz postmana adresa
            String url = "http://api.weatherapi.com/v1/forecast.json?key=e58e1c9ca4b546c0825125407232211&q=city&days=1&aqi=no&alerts=no";
            HttpHeaders headers = new HttpHeaders();
            headers.put("apiKey", List.of("e58e1c9ca4b546c0825125407232211"));
            headers.put("maxTemp_c", List.of(""));
            headers.put("minTemp_c", List.of(""));
            headers.put("avgTemp_c", List.of(""));
            HttpEntity<?> httpEntity = new HttpEntity<>(null, headers);
            ParameterizedTypeReference<Map<String, List<Parameters>>> responseReference = new ParameterizedTypeReference<>() {};
            ResponseEntity<Map<String, List<Parameters>>> response = restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    httpEntity,
                    responseReference
            );
            return response.getBody();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}
