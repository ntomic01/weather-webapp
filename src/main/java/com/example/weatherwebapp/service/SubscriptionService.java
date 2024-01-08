package com.example.weatherwebapp.service;

import java.util.List;

import com.example.weatherwebapp.domain.Subscription;
import com.example.weatherwebapp.domain.dto.request.SubscriptionRequest;

public interface SubscriptionService {

    List<Subscription> findAll(String token);

    void saveSubscription(String token, SubscriptionRequest subcriptionRequest);

    void deleteSubscription(String token, SubscriptionRequest subscriptionRequest);



}
