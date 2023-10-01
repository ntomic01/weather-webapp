package com.example.weatherwebapp.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.weatherwebapp.domain.User;
import com.example.weatherwebapp.repository.UserRepository;
import com.example.weatherwebapp.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Primary
@Service
public class JWTTokenServiceImpl implements TokenService {
    @Autowired
    private UserRepository userRepository;

    private static final long EXPIRATION_TIME = 3600000;

    @Value("${token.secret}")
    private String tokenSecret;

    private final JWTVerifier verifier;

    private JWTTokenServiceImpl(@Value("${token.secret}")String tokenSecret){
        this.tokenSecret = tokenSecret;
        this.verifier = JWT.require(Algorithm.HMAC256(tokenSecret)).build();
    }

    @Override
    public String generate(User user) {
        JWTCreator.Builder builder = JWT.create();
        builder.withClaim("id", user.getId());
        builder.withClaim("email", user.getEmail());
        builder.withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME));
        return builder.sign(Algorithm.HMAC512(tokenSecret));
    }

    @Override
    public User findUserByToken(String token) {
        DecodedJWT decodedJWT = verifier.verify(token);
        Long id = decodedJWT.getClaim("id").asLong();
        Optional<User> optionalUser = userRepository.findById(id);
        if(optionalUser.isEmpty()){
            throw new RuntimeException("user not found!");
        }
        return optionalUser.get();
    }
}
