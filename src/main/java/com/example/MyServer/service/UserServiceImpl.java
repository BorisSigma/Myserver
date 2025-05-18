package com.example.MyServer.service;

import com.example.MyServer.domain.User;
import com.example.MyServer.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import java.beans.Transient;
import java.util.ArrayList;
@AllArgsConstructor
@Service
@RequestMapping
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    @Override
    @Transactional(readOnly = true)
    public User getById(long id) {
        if(id > 0){
            return userRepository.findById(id).orElseThrow(() -> new RuntimeException("Пользователя нет"));
        }
        throw new RuntimeException("Id не подходит");
    }

    @Override
    @Transactional(readOnly = true)
    public ArrayList<User> getAllUsers() {
        return (ArrayList<User>) userRepository.findAll();
    }
    @Transactional(readOnly = true)
    public User getUserByLogin(String login){
        return userRepository.getUserByLogin(login);
    }

    @Override
    @Transactional
    public User updateUser(User user) {
        if(userRepository.existsById(user.getId()))return userRepository.save(user);
        throw new RuntimeException("Пользоваетель не найден");
    }

    @Override
    @Transactional
    public User addUser(User user) {
        if(userRepository.existsById(user.getId()))throw new RuntimeException("Пользователь уже существует");
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public void deleteUserById(long id) {
        if (userRepository.existsById(id)){
            userRepository.deleteById(id);
        }
        else {
            throw new RuntimeException("Пользователь не найден");
        }

    }
}
