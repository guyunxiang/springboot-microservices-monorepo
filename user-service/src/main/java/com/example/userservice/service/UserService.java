package com.example.userservice.service;

import com.example.userservice.model.User;
import com.example.userservice.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Get all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Get user by userId
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    // Add new user
    public User createUser(User user) {
        return userRepository.save(user);
    }

    // Update user data
    public User updateUser(Long id, User user) {
        return userRepository.findById(id).map(u -> {
            u.setName(user.getName());
            return userRepository.save(u);
        }).orElse(null);
    }

    // Delete user
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
