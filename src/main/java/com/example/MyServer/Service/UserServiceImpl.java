package com.example.MyServer.Service;

import com.example.MyServer.domain.Event;
import com.example.MyServer.domain.User;
import com.example.MyServer.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    @Override
    public User getById(long id) {
        if(id > 0){
            return userRepository.findById(id).orElseThrow(() -> new RuntimeException("Пользователя нет"));
        }
        throw new RuntimeException("Id не подходит");
    }

    @Override
    public ArrayList<User> getAllUsers() {
        return (ArrayList<User>) userRepository.findAll();
    }

    public User getUserByLogin(String login){
        return userRepository.getUserByLogin(login);
    }

    @Override
    public User updateUser(User user) {
        if(userRepository.existsById(user.getId()))return userRepository.save(user);
        throw new RuntimeException("Пользоваетель не найден");
    }

    @Override
    public User addUser(User user) {
        if(userRepository.existsById(user.getId()))throw new RuntimeException("Пользователь уже существует");
        return userRepository.save(user);
    }

    @Override
    public void deleteUserById(long id) {
        if (userRepository.existsById(id)){
            userRepository.deleteById(id);
        }
        else {
            throw new RuntimeException("Пользователь не найден");
        }

    }
}
