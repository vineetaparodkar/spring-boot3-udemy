package com.example.springbootcrudrestapi.service.impl;

import com.example.springbootcrudrestapi.dto.UserDto;
import com.example.springbootcrudrestapi.entity.User;
import com.example.springbootcrudrestapi.exception.EmailAlreadyExistsException;
import com.example.springbootcrudrestapi.exception.ResourceNotFoundException;
//import com.example.springbootcrudrestapi.mapper.AutoUserMapper;
import com.example.springbootcrudrestapi.mapper.UserMapper;
import com.example.springbootcrudrestapi.repository.UserRepository;
import com.example.springbootcrudrestapi.service.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final ModelMapper modelMapper;

    @Override
    public UserDto createUser(UserDto userDto) {

        //custom exception
        userRepository.findByEmail(userDto.getEmail()).orElseThrow(
                ()-> new EmailAlreadyExistsException("Email Already exists for user")
        );

        //using mapper here since the conversion logic is used at many places.
        User user = UserMapper.mapToUser(userDto);
        User savedUser = userRepository.save(user);

        //using mapper here since the conversion logic is used at many places.
        UserDto savedUserDto = UserMapper.mapToUserDto(savedUser);


        //using model mapper library
        //UserDto savedUserDto = modelMapper.map(savedUser, UserDto.class);

        //using mapstruct mapper library
        //UserDto savedUserDto = AutoUserMapper.MAPPER.mapToUserDto(savedUser);

        return savedUserDto;
    }

    @Override
    public UserDto getUserById(Long id) throws ResourceNotFoundException {
        Optional<User> userOptional = userRepository.findById(id);
        UserDto userDto = UserMapper.mapToUserDto(userOptional.orElseThrow(
                () -> new ResourceNotFoundException("User", "id", id)
        ));
        return userDto;
    }

    @Override
    public List<UserDto> getAllUsers() {
        Optional<List<User>> userOptional = Optional.of(userRepository.findAll());

        //using model mapper
        //userOptional.orElse(null).stream().map((user)->modelMapper.map(user, UserDto.class)).toList();

        //using mapstruct mapper library
        //userOptional.orElse(null).stream().map(AutoUserMapper.MAPPER::mapToUserDto).toList();

        return userOptional.orElse(null).stream().map(UserMapper::mapToUserDto).toList();
    }

    @Override
    public UserDto updateUser(Long id, UserDto user) throws ResourceNotFoundException{
        User existingUser = userRepository.findById(user.getId()).orElseThrow(
                () -> new ResourceNotFoundException("User", "id", id)
        );
        existingUser.setEmail(user.getEmail());
        existingUser.setLastName(user.getLastName());
        existingUser.setFirstName(user.getFirstName());
        User response = userRepository.save(existingUser);
        return UserMapper.mapToUserDto(response);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
