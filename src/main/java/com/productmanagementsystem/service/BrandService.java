package com.productmanagementsystem.service;


import com.productmanagementsystem.dto.brand.BrandDto;
import com.productmanagementsystem.dto.brand.BrandResponseDto;
import com.productmanagementsystem.entity.Brand;
import com.productmanagementsystem.exception.DuplicateResourceException;
import com.productmanagementsystem.exception.ResourceNotFoundException;
import com.productmanagementsystem.mapper.BrandMapper;
import com.productmanagementsystem.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BrandService {

    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private BrandMapper brandMapper;


    public List<BrandResponseDto> getBrands() {
        List<Brand> brands = brandRepository.findAll();
        return brandMapper.toDtoList(brands);
    }

    public void createBrand(BrandDto dto) {
        if (brandRepository.existsByBrandName(dto.getBrandName())) {
            throw new DuplicateResourceException("brand already exists");
        }
        Brand brand = brandMapper.toEntity(dto);
        brandRepository.save(brand);
    }

    public void putBrand(Long brandId , BrandDto dto){
        Brand brand = brandRepository.findById(brandId)
                .orElseThrow(() -> new ResourceNotFoundException("brandId not found"));
        brandMapper.updateBrand(brand , dto);
        brandRepository.save(brand);
    }

    public void deleteBrand(Long brandId){
        Brand brand = brandRepository.findById(brandId)
                .orElseThrow(() -> new ResourceNotFoundException("brandId not found"));
        brandRepository.delete(brand);
    }
}
