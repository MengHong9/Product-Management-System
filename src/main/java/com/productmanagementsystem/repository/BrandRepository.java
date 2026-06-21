package com.productmanagementsystem.repository;

import com.productmanagementsystem.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BrandRepository extends JpaRepository<Brand,Long> {
    boolean existsByBrandName(String brandName);
}
