package com.productmanagementsystem.mapper;

import com.productmanagementsystem.dto.user.UserDto;
import com.productmanagementsystem.dto.user.UserResponseDto;
import com.productmanagementsystem.dto.user.UserUpdateDto;
import com.productmanagementsystem.entity.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    public User toEntity(UserDto dto){
        User user = new User();
        user.setName(dto.getName());
        user.setPassword(dto.getPassword());
        user.setEmail(dto.getEmail());
        user.setRole(dto.getRole());

        return user;
    }


    public UserResponseDto toDto(User user){
        UserResponseDto dto = new UserResponseDto();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setPassword(user.getPassword());
        dto.setEmail(user.getEmail());
        dto.setRole(user.getRole());
        dto.setCreatedDate(user.getCreatedDate());
        dto.setUpdatedDate(dto.getUpdatedDate());

        return dto;
    }


    public List<UserResponseDto> toDtoList(List<User> users){
        if (users == null || users.isEmpty()){
            return new ArrayList<>();
        }

        return users.stream().map(this::toDto).collect(Collectors.toList());
    }

    public void updateUser(User user ,UserUpdateDto dto){
        if (user == null || dto == null){
            return;
        }

        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setRole(dto.getRole());
    }

}
