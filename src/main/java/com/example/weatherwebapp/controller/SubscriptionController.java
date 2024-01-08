package com.example.weatherwebapp.controller;

import com.example.weatherwebapp.domain.Subscription;
import com.example.weatherwebapp.domain.dto.request.SubscriptionRequest;
import com.example.weatherwebapp.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subscription")
public class SubscriptionController {
    @Autowired
    private SubscriptionService subscriptionService;

    @GetMapping("/findAll")
    public List<Subscription> findAll(@RequestHeader("Authorization") String token){
        return subscriptionService.findAll(token);
    }

    @PostMapping("/save")
    public void saveSubcription(@RequestHeader("Authorization") String token , @RequestBody SubscriptionRequest subcriptionRequest) {
        subscriptionService.saveSubscription(token,subcriptionRequest);
    }

    @DeleteMapping("/delete")
    public void deleteSubscription(@RequestHeader("Authorization") String token, @RequestBody SubscriptionRequest subscriptionRequest){
        subscriptionService.deleteSubscription(token,subscriptionRequest);
    }

}
