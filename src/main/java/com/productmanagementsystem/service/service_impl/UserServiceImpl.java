package com.productmanagementsystem.service.service_impl;

import com.productmanagementsystem.dto.user.UserDto;
import com.productmanagementsystem.dto.user.UserResponseDto;
import com.productmanagementsystem.dto.user.UserUpdateDto;
import com.productmanagementsystem.entity.User;
import com.productmanagementsystem.exception.DuplicateResourceException;
import com.productmanagementsystem.exception.ResourceNotFoundException;
import com.productmanagementsystem.mapper.UserMapper;
import com.productmanagementsystem.repository.UserRepository;
import com.productmanagementsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<UserResponseDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return userMapper.toDtoList(users);
    }

    @Override
    public void createUser(UserDto dto) {
        if (userRepository.existsUserByName(dto.getName())){
            throw new DuplicateResourceException("name already existed");
        }
        if (userRepository.existsUserByEmail(dto.getEmail())){
            throw new DuplicateResourceException("email already existed");
        }

        User user = userMapper.toEntity(dto);
        userRepository.save(user);
    }

    @Override
    public void putUser(Long id, UserUpdateDto dto) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("id not found"));

        userMapper.updateUser(user , dto);
        userRepository.save(user);
    }

    @Override
    public void removeUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("id not found"));

        userRepository.delete(user);
    }

    @Override
    public UserResponseDto getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("id not found"));

        return userMapper.toDto(user);

    }

    @Override
    public UserResponseDto getUserByName(String name) {
        User user = userRepository.findByNameContainingIgnoreCase(name);
        return userMapper.toDto(user);
    }
}
