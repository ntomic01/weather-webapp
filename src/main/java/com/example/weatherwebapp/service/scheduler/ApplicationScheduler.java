package com.example.weatherwebapp.service.scheduler;

import com.example.weatherwebapp.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ApplicationScheduler {

    @Autowired
    private WeatherService weatherService;

    @Scheduled(fixedDelay = 5000)
    public void triggerHi() {
        System.out.println("hi");
    }

    @Scheduled(cron = "0 7 * * * ?")
    public void triggerFetchWeatherData() {
        weatherService.fetchWeatherData();
    }

    @Scheduled(cron = "0 8 * * * ?")
    public void triggerSendDateToUser() {
        // todo: user serice napraviti metodu za to
    }

}
