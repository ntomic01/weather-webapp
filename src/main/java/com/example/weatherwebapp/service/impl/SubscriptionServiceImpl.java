package com.example.weatherwebapp.service.impl;

import com.example.weatherwebapp.domain.City;
import com.example.weatherwebapp.domain.Subscription;
import com.example.weatherwebapp.domain.User;
import com.example.weatherwebapp.repository.SubscriptionRepository;
import com.example.weatherwebapp.repository.UserRepository;
import com.example.weatherwebapp.service.SubscriptionService;
import com.example.weatherwebapp.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {
    @Autowired
    private SubscriptionRepository subscriptionRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TokenService tokenService;

    @Override
    public List<Subscription> findAll(String token) {
        List<Subscription> subscriptions = new ArrayList<>();
        User currentUser = tokenService.findUserByToken(token);
        for(Subscription subscription: currentUser.getSubscriptions()){
            subscriptions.add(subscription);
        }
        return subscriptions;
    }
    @Override
    public void save(Subscription subscription){

    }

}
