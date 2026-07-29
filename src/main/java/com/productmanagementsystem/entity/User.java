package com.productmanagementsystem.entity;


import com.productmanagementsystem.common.enums.UserRole;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String password;
    private String email;

    @Enumerated(EnumType.STRING)
    private UserRole role;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;


    @PrePersist
    public void preCreatedDate(){
        createdDate = LocalDateTime.now();
    }


    @PreUpdate
    public void preUpdatedDate(){
        updatedDate = LocalDateTime.now();
    }
}
