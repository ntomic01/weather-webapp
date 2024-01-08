package com.example.weatherwebapp.repository;

import com.example.weatherwebapp.domain.User;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);
    User findByEmailAndPassword(String email, String password);
    User findByEmail(String email);
    Optional<User> findById(Long userId);

}
