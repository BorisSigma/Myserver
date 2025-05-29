package com.example.MyServer.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor(force = true)
@Table(name = "users")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final long id;
    @Column(name = "login")
    private final String login;
    @Column(name = "city")
    private final String city;
    @Column(name = "starsValue")
    private final double starsValue;
    @Column(name = "username")
    private final String username;
    @Column(name = "password")
    private final String password;

}
