package com.example.springbootcrudrestapi.mapper;

import com.example.springbootcrudrestapi.dto.UserDto;
import com.example.springbootcrudrestapi.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AutoUserMapper {

    AutoUserMapper MAPPER = Mappers.getMapper(AutoUserMapper.class); // mapstruct will create the implementation for autousermapper interface at compilation time and we can use
    //mapper instance then to call these methods

    //define 2 mapping methods mapstruct will create the implementation will create the implementation at compile time
    //mapstruct will require same field name but also if field name differs then there is way to map those differences as well use mapping annotation

    @Mapping(source = "email", target = "email")
    UserDto mapToUserDto(User user);

    User mapToUser(UserDto userDto);
}
