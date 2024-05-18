package com.example.springbootcrudrestapi.service.impl;

import com.example.springbootcrudrestapi.entity.User;
import com.example.springbootcrudrestapi.repository.UserRepository;
import com.example.springbootcrudrestapi.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        return userOptional.orElse(null);
    }

    @Override
    public List<User> getAllUsers() {
        Optional<List<User>> userOptional = Optional.of(userRepository.findAll());
        return userOptional.orElse(null);
    }

    @Override
    public User updateUser(Long id, User user) {
        User existingUser = userRepository.findById(user.getId()).get();
        existingUser.setEmail(user.getEmail());
        existingUser.setLastName(user.getLastName());
        existingUser.setFirstName(user.getFirstName());
        User response =userRepository.save(existingUser);
        return response;
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
