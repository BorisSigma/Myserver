package com.example.MyServer.repository;

import com.example.MyServer.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Client, Long> {
    Client getUserByLogin(String login);
}
