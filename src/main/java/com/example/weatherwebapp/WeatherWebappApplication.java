package com.example.weatherwebapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class WeatherWebappApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherWebappApplication.class, args);
	}

}
