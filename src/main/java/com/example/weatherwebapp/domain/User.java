package com.example.weatherwebapp.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastName;
    @Column(unique = true)
    private String email;
    private String password;
    private String token;
    private boolean accountVerified;

    @OneToMany(mappedBy = "user")
    private Set<SecureToken> tokens;

    @OneToMany(mappedBy = "user")
    @ToString.Exclude
    private List<Subscription> subscriptions;

}
