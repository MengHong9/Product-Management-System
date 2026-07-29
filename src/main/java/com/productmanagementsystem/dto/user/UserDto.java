package com.productmanagementsystem.dto.user;

import com.productmanagementsystem.common.enums.UserRole;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserDto {

    @NotBlank(message = "name is required")
    @Size(min = 5, max = 15 , message = "name must be between 5 to 15 characters")
    private String name;


    @NotBlank(message = "password is required")
    @Size(min = 6, max = 15 , message = "password must be between 6 to 15 characters")
    private String password;

    @NotBlank(message = "email is required")
    @Size(min = 6, max = 20 , message = "name must be between 6 to 20 characters")
    private String email;


    private UserRole role = UserRole.USER;
}
