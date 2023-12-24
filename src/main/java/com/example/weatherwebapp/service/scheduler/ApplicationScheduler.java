package com.example.weatherwebapp.service.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ApplicationScheduler {

    @Scheduled(fixedDelay = 5000)
    public void triggerHi() {
        System.out.println("hi");
    }

}
