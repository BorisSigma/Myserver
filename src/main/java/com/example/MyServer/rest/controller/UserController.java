package com.example.MyServer.rest.controller;


import com.example.MyServer.domain.Client;

import java.util.ArrayList;

public interface UserController {
    Client getById(long id);
    ArrayList<Client> getAllUsers();
    Client updateUser(Client user);
    Client addUser(Client user);
    void deleteUserById(long id);
    Client getUserByLogin(String login);
        
}
