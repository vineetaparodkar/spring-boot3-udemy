package com.example.springbootcrudrestapi.mapper;

import com.example.springbootcrudrestapi.dto.UserDto;
import com.example.springbootcrudrestapi.entity.User;

public class UserMapper {

    public static UserDto mapToUserDto(User user) {
        UserDto userDto = new UserDto(user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail());
        return userDto;
    }

    public static User mapToUser(UserDto userDto) {
        User user = new User(userDto.getId(),
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getEmail());
        return user;
    }
}
