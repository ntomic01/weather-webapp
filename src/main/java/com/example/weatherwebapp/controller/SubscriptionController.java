package com.example.weatherwebapp.controller;

import com.example.weatherwebapp.domain.City;
import com.example.weatherwebapp.domain.Subscription;
import com.example.weatherwebapp.domain.User;
import com.example.weatherwebapp.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subscription")
public class SubscriptionController {
    @Autowired
    private SubscriptionService subscriptionService;

    @GetMapping("/findAll")
    public List<Subscription> findAll(@RequestHeader("/Authorization") String token){
        return subscriptionService.findAll(token);
    }

}
