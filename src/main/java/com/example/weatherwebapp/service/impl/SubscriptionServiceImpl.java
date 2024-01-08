package com.example.weatherwebapp.service.impl;

import com.example.weatherwebapp.domain.City;
import com.example.weatherwebapp.domain.Subscription;
import com.example.weatherwebapp.domain.User;
import com.example.weatherwebapp.domain.dto.request.SubscriptionRequest;
import com.example.weatherwebapp.repository.CityRepository;
import com.example.weatherwebapp.repository.SubscriptionRepository;
import com.example.weatherwebapp.repository.UserRepository;
import com.example.weatherwebapp.service.CityService;
import com.example.weatherwebapp.service.SubscriptionService;
import com.example.weatherwebapp.service.TokenService;
import com.example.weatherwebapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {
    @Autowired
    private SubscriptionRepository subscriptionRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TokenService tokenService;
    @Autowired
    private UserService userService;
    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private CityService cityService;

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
    public void saveSubscription(String token, SubscriptionRequest subcriptionRequest){

        User currentUser = tokenService.findUserByToken(token);

        City city = cityRepository.findById(subcriptionRequest.getCityId());

        Subscription subscription = new Subscription();

        subscription.setUser(currentUser);
        subscription.setCity(city);

        subscriptionRepository.save(subscription);


    }

    @Override
    public void deleteSubscription(String token, SubscriptionRequest subscriptionRequest) {

        User currentUser = tokenService.findUserByToken(token);

        List<Subscription> subscriptions = findAll(token);

        for(Subscription subscription: currentUser.getSubscriptions()){
            if(subscription.getCity().getId().equals(subscriptionRequest.getCityId())){
                subscriptionRepository.deleteById(subscription.getId());
            }
        }






    }


}




