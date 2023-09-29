package com.example.weatherwebapp.config;

import org.indigo.dtomapper.providers.MapperFactory;
import org.indigo.dtomapper.providers.specification.Mapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ServerConfig {

    @Bean("restTemplateTest")
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    public Mapper getMapper() {
        return MapperFactory.getMapper();
    }

}
