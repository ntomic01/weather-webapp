package com.example.weatherwebapp.repository;

import com.example.weatherwebapp.domain.Subscription;
import com.example.weatherwebapp.domain.User;
import com.example.weatherwebapp.domain.dto.request.SubscriptionRequest;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionRepository extends JpaRepository<Subscription,Long> {
//    @Query("from Subscription sb where sb.user.id = :userId and sb.city.Id = :cityId")
//    Subscription deleteSubByUserIdAndCityId(String token, Long cityId);


//    Subscription findByUser_IdAndId(String token, SubscriptionRequest subscriptionRequest);

    @Override
    boolean existsById(Long aLong);
}
