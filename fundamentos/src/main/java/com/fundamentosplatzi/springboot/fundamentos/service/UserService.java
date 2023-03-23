package com.fundamentosplatzi.springboot.fundamentos.service;

import com.fundamentosplatzi.springboot.fundamentos.model.User;
import com.fundamentosplatzi.springboot.fundamentos.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public Optional<User> getById(long id) {
        return  userRepository.findById(id);
    }

    public User getByName(String name) {
        return  userRepository.findByName(name);
    }

    public User createUser(User newUser) {
        return userRepository.save(newUser);
    }

    public Optional<User> updateUser(User newUser, long id) {
        return userRepository.findById(id).map(
                user -> {
                    user.setName(newUser.getName());
                    user.setEmail(newUser.getEmail());
                    user.setBirth(newUser.getBirth());
                    return userRepository.save(user);
                }
        );
    }

    public Optional<User> deleteUser(long id) {
        Optional<User> userDeleted = userRepository.findById(id);
        userRepository.deleteById(id);
        return userDeleted;
    }
}
