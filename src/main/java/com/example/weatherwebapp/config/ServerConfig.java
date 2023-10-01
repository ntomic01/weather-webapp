package com.example.weatherwebapp.config;

import org.indigo.dtomapper.providers.MapperFactory;
import org.indigo.dtomapper.providers.specification.Mapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ServerConfig implements WebMvcConfigurer {

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**").allowedMethods("*");
	}

	@Bean
	public Mapper getMapper() {
		return MapperFactory.getMapper();
	}

//	@Bean
//	public RestTemplate getRestTemplate(){
//		return new RestTemplate();
//	}
}
