package com.productmanagementsystem.service;



import com.productmanagementsystem.dto.user.UserDto;
import com.productmanagementsystem.dto.user.UserResponseDto;
import com.productmanagementsystem.dto.user.UserUpdateDto;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {
    public List<UserResponseDto> getAllUsers();

    public void createUser(UserDto dto);

    public void putUser(Long id , UserUpdateDto dto);

    public void removeUser(Long id);

    public UserResponseDto getUserById(Long id);

    public UserResponseDto getUserByName(String name);
}
