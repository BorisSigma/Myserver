package com.example.MyServer.rest.controller;

import com.example.MyServer.service.UserService;
import com.example.MyServer.domain.Client;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@AllArgsConstructor
@RestController
public class UserControllerImpl implements UserController{
    private UserService userService;

    @Override
    @GetMapping(path = "/user/{id}")
    public Client getById(@PathVariable(name = "id") long id) {
        return userService.getById(id);
    }

    @Override
    @GetMapping(path = "/user")
    public ArrayList<Client> getAllUsers() {
        return userService.getAllUsers();
    }

    @Override
    @PutMapping(path = "/user")
    public Client updateUser(@RequestBody Client user) {
        return userService.updateUser(user);
    }

    @Override
    @PostMapping(path = "/user")
    public Client addUser(@RequestBody Client user) {
        return userService.addUser(user);
    }

    @Override
    @DeleteMapping(path = "/user/{id}")
    public void deleteUserById(@PathVariable(name = "id") long id) {
        userService.deleteUserById(id);

    }

    @Override
    @GetMapping(path = "/user/login/{login}")
    public Client getUserByLogin(@PathVariable(name = "login") String login) {
        return userService.getUserByLogin(login);
    }
}
