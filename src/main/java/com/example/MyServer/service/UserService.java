package com.example.MyServer.service;

import com.example.MyServer.domain.Client;

import java.util.ArrayList;

public interface UserService {
    Client getById(long id);
    ArrayList<Client> getAllUsers();
    Client updateUser(Client user);
    Client addUser(Client user);
    void deleteUserById(long id);
    Client getUserByLogin(String login);
}
