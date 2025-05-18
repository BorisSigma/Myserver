package com.example.MyServer.service;

import com.example.MyServer.domain.User;

import java.util.ArrayList;

public interface UserService {
    User getById(long id);
    ArrayList<User> getAllUsers();
    User updateUser(User user);
    User addUser(User user);
    void deleteUserById(long id);
    User getUserByLogin(String login);
}
