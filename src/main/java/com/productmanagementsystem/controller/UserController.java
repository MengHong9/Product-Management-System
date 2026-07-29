package com.productmanagementsystem.controller;

import com.productmanagementsystem.common.response.Response;
import com.productmanagementsystem.dto.user.UserDto;
import com.productmanagementsystem.dto.user.UserResponseDto;
import com.productmanagementsystem.dto.user.UserUpdateDto;
import com.productmanagementsystem.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<Response> getUsers(){
        List<UserResponseDto> dtos = userService.getAllUsers();

        return ResponseEntity.status(HttpStatus.OK).body(Response.success("200" , "success" , "successfully retrieved user" , dtos));
    }

    @PostMapping
    public ResponseEntity<Response> addUser(@Valid @RequestBody UserDto dto){
        userService.createUser(dto);
        return ResponseEntity.status(HttpStatus.OK).body(Response.success("201" , "success" , "successfully created user"));
    }

    @PutMapping("{id}")
    public ResponseEntity<Response> putUser(@PathVariable Long id , @Valid @RequestBody UserUpdateDto dto){
        userService.putUser(id , dto);
        return ResponseEntity.status(HttpStatus.OK).body(Response.success("200" , "success" , "successfully updated user"));
    }


    @DeleteMapping("{id}")
    public ResponseEntity<Response> deleteUser(@PathVariable Long id){
        userService.removeUser(id);
        return ResponseEntity.status(HttpStatus.OK).body(Response.success("200" , "success" , "successfully deleted user"));
    }

    @GetMapping("{id}")
    public ResponseEntity<Response> getUserById(@PathVariable Long id){
        UserResponseDto dto = userService.getUserById(id);
        return ResponseEntity.status(HttpStatus.OK).body(Response.success("200" , "success" , "successfully retrieved user" , dto));
    }

    @GetMapping("/search")
    public ResponseEntity<Response> getUserByName(@RequestParam String name){
        UserResponseDto dto = userService.getUserByName(name);
        return ResponseEntity.status(HttpStatus.OK).body(Response.success("200" , "success" , "successfully retrieved user" , dto));
    }



}
