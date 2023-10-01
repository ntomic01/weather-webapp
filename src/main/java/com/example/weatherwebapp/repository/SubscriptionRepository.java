package com.example.weatherwebapp.repository;

import com.example.weatherwebapp.domain.Subscription;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionRepository extends JpaRepository<Subscription,Long> {

    boolean existsSub(Long id);
}
