package com.example.springbootcrudrestapi.service;

import com.example.springbootcrudrestapi.dto.UserDto;
import com.example.springbootcrudrestapi.exception.ResourceNotFoundException;

import java.util.List;

public interface UserService {
     UserDto createUser(UserDto user);

     UserDto getUserById(Long id) throws ResourceNotFoundException;

     List<UserDto> getAllUsers();

     UserDto updateUser(Long id, UserDto user) throws ResourceNotFoundException;

     void deleteUser(Long id);
}
