package com.example.weatherwebapp.service;

import com.example.weatherwebapp.domain.User;

public interface TokenService {

    // za prosledjenog usera generisemo tj pravimo token.
    String generate(User user);

    // za prosledjen tj izgenerisan token vracamo usera.
    User findUserByToken(String token);

}
