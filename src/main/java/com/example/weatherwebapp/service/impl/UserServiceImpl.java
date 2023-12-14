package com.example.weatherwebapp.service.impl;

import com.example.weatherwebapp.domain.User;
import com.example.weatherwebapp.domain.dto.request.LoginRequest;
import com.example.weatherwebapp.domain.dto.request.RegisterRequest;
import com.example.weatherwebapp.domain.dto.response.LoginResponse;
import com.example.weatherwebapp.domain.dto.response.UserResponse;
import com.example.weatherwebapp.repository.UserRepository;
import com.example.weatherwebapp.service.EmailSenderService;
import com.example.weatherwebapp.service.TokenService;
import com.example.weatherwebapp.service.UserService;
import org.indigo.dtomapper.providers.specification.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TokenService tokenService;
    @Autowired
    private EmailSenderService emailSenderService;
    @Autowired
    private Mapper mapper;

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

        User user = userRepository.findByEmail(loginRequest.getEmail());

        if(user == null){
           throw new RuntimeException("user not found!");
        }
        if(!loginRequest.getPassword().equals(user.getPassword())) {
            throw new RuntimeException("bad credentials!");
        }
        if(!user.isAccountVerified()) {
            throw new RuntimeException("account isn't verified!");
        }

        String token = tokenService.generate(user);
        System.out.println(token);
        return new LoginResponse(token);

    }

    @Override
    public UserResponse register(RegisterRequest registerRequest) {
        // prvo se pitam da li postoji user sa vec tim email i passwordom
        if(userRepository.existsByEmail(registerRequest.getEmail())){
            throw new RuntimeException("user vec postoji s tim imejlom");
        }
        // tim pre sto ako kazes da vec postoji user s tim passwordom moze da uzme i redom da proverava usernomove dok ne provali :D
        // ako ovo prodje setuje iz postmana sve atribute koje sam zadao sve parametre
        User user = mapper.map(registerRequest, User.class);
        userRepository.save(user);
        // ovde treba jos za mail da sredim!!!
        emailSenderService.sendVerificationMail(registerRequest.getEmail());
        return mapper.map(user,UserResponse.class);
    }

    @Override
    public void verifyAccount(String email) {
        User user = userRepository.findByEmail(email);
        if(user == null){
            throw new RuntimeException("user s tim imejlom ne postoji");
        }
        user.setAccountVerified(true);
        userRepository.save(user);
        // Ovde sam probao long userId ali mi trazi optional user pa ne znam sta da vratim i onda sam stavio mejl a to vrv nije bas logicno :D
    }

    @Override
    public User findById(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        return null;
    }


}
