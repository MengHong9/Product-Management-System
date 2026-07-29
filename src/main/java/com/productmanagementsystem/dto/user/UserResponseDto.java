package com.productmanagementsystem.dto.user;


import com.productmanagementsystem.common.enums.UserRole;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserResponseDto {
    private Long id;
    private String name;
    private String password;
    private String email;
    private UserRole role;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
}
