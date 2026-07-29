package com.productmanagementsystem.repository;

import com.productmanagementsystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface UserRepository extends JpaRepository<User , Long> {
    boolean existsUserByName(String name);
    boolean existsUserByEmail(String email);

    User findByNameContainingIgnoreCase(String name);
}
