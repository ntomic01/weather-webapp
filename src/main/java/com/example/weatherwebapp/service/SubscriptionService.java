package com.example.weatherwebapp.service;

import java.util.List;

import com.example.weatherwebapp.domain.Subscription;

public interface SubscriptionService {

    List<Subscription> findAll(String token);

    void save(Subscription subscription);



}
