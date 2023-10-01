package com.example.weatherwebapp.service;

import com.example.weatherwebapp.domain.City;
import com.example.weatherwebapp.domain.Subscription;
import com.example.weatherwebapp.domain.User;

import java.util.List;

public interface SubscriptionService {

    List<Subscription> findAll(String token);

    void save(Subscription subscription);

}
