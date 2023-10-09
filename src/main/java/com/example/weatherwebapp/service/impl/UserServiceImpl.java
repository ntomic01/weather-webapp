package com.example.weatherwebapp.service.impl;

import com.example.weatherwebapp.domain.User;
import com.example.weatherwebapp.domain.dto.request.LoginRequest;
import com.example.weatherwebapp.domain.dto.request.RegisterRequest;
import com.example.weatherwebapp.domain.dto.response.LoginResponse;
import com.example.weatherwebapp.repository.UserRepository;
import com.example.weatherwebapp.service.EmailSenderService;
import com.example.weatherwebapp.service.TokenService;
import com.example.weatherwebapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TokenService tokenService;
    @Autowired
    private EmailSenderService emailSenderService;

    public List<User> getActive(){
        return userRepository.findAll();
    }

    public void save(User user){

        // ova metoda kreira novog usera

        if(userRepository.existsByEmail(user.getEmail())) {
            throw new RuntimeException("User this with email already exists.");
        }
        userRepository.save(user);
    }

    @Override
    public LoginResponse login(LoginRequest loginRequest) {

        // ova metoda loguje postojeceg usera

        User user = userRepository.findByEmailAndPassword(loginRequest.getEmail(), loginRequest.getPassword());

        if(user == null){
           throw new RuntimeException("user not found!");
        }

        String token = tokenService.generate(user);
        System.out.println(token);
        return new LoginResponse(token);

    }

    @Override
    public User register(RegisterRequest registerRequest) {
        // prvo se pitam da li postoji user sa vec tim email i passwordom
        if(userRepository.findByEmail(registerRequest.getEmail())!= null){
            throw new RuntimeException("user vec postoji s tim imejlom");
        }
        if(userRepository.findByPassword(registerRequest.getPassword())!=null){
            throw new RuntimeException("user vec postoji s tim passwordom");
        }
        // ako ovo prodje setuje iz postmana sve atribute koje sam zadao sve parametre
        User user = new User();
        user.setName(registerRequest.getFirstName());
        user.setLastName(registerRequest.getLastName());
        user.setEmail(registerRequest.getEmail());
        user.setPassword(registerRequest.getPassword());
        user.setVerified(false);

        // nakon njegove registracije, on dobija token s kojim ide dalje tj sacuvan ce biti u bazu i sledi verifikacija

        String token = tokenService.generate(user);
        System.out.println(token);

        return userRepository.save(user);

        // ovde treba jos za mail da sredim!!!
    }

    @Override
    public User verifyAccount(String email) {
        User user = userRepository.findByEmail(email);
        if(user.getEmail()==null){
            throw new RuntimeException("user s tim imejlom postoji");
        }
        user.setVerified(true);
        userRepository.save(user);
        return user;

        // Ovde sam probao long userId ali mi trazi optional user pa ne znam sta da vratim i onda sam stavio mejl a to vrv nije bas logicno :D
    }



}
