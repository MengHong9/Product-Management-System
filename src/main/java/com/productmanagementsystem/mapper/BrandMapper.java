package com.productmanagementsystem.mapper;


import com.productmanagementsystem.dto.brand.BrandDto;
import com.productmanagementsystem.dto.brand.BrandResponseDto;
import com.productmanagementsystem.entity.Brand;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class BrandMapper {

    public Brand toEntity(BrandDto dto){
        Brand brand = new Brand();
        brand.setBrandName(dto.getBrandName());
        brand.setCountry(dto.getCountry());
        return brand;
    }


    public BrandResponseDto toDto(Brand brand){
        BrandResponseDto dto = new BrandResponseDto();
        dto.setBrandId(brand.getBrandId());
        dto.setBrandName(brand.getBrandName());
        dto.setCountry(brand.getCountry());
        dto.setCreatedDate(brand.getCreatedDate());
        dto.setUpdatedDate(brand.getUpdatedDate());
        return dto;
    }

    public List<BrandResponseDto> toDtoList(List<Brand> brands){
        if (brands == null || brands.isEmpty()){
            return new ArrayList<>();
        }
        return brands.stream().map(entity-> toDto(entity)).collect(Collectors.toList());
    }

    public void updateBrand(Brand brand , BrandDto dto){
        if (brand == null || dto == null){
            return;
        }

        brand.setBrandName(dto.getBrandName());
        brand.setCountry(dto.getCountry());
    }
}
