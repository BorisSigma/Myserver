package com.example.MyServer.rest.controller;

import com.example.MyServer.service.UserService;
import com.example.MyServer.domain.User;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@AllArgsConstructor
@RestController
@Service
public class UserControllerImpl implements UserController{
    private UserService userService;

    @Override
    @GetMapping(path = "/user/{id}")
    public User getById(@PathVariable(name = "id") long id) {
        return userService.getById(id);
    }

    @Override
    @GetMapping(path = "/user")
    public ArrayList<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @Override
    @PutMapping(path = "/user")
    public User updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @Override
    @PostMapping(path = "/user")
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @Override
    @DeleteMapping(path = "/user/{id}")
    public void deleteUserById(@PathVariable(name = "id") long id) {
        userService.deleteUserById(id);

    }

    @Override
    @GetMapping(path = "/user/{login}")
    public User getUserByLogin(@PathVariable(name = "login") String login) {
        return userService.getUserByLogin(login);
    }
}
