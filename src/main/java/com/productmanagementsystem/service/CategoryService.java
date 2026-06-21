package com.productmanagementsystem.service;


import com.productmanagementsystem.dto.category.CategoryDto;
import com.productmanagementsystem.dto.category.CategoryResponseDto;
import com.productmanagementsystem.entity.Category;
import com.productmanagementsystem.exception.DuplicateResourceException;
import com.productmanagementsystem.exception.ResourceNotFoundException;
import com.productmanagementsystem.mapper.CategoryMapper;
import com.productmanagementsystem.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryMapper categoryMapper;


    public List<CategoryResponseDto> findAll() {
        List<Category> categories = categoryRepository.findAll();
        return categoryMapper.toDtoList(categories);
    }


    public void addCategory(CategoryDto dto) {
        if (categoryRepository.existsByCategoryName(dto.getCategoryName())) {
            throw new DuplicateResourceException("category already exists");
        }
        Category category = categoryMapper.toEntity(dto);
        categoryRepository.save(category);
    }

    public void putCategory(Long categoryId , CategoryDto dto){
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(()->new ResourceNotFoundException("categoryId not found"));

        categoryMapper.changeCategory(category , dto);
        categoryRepository.save(category);
    }

    public void deleteCategoryById(Long categoryId){
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(()->new ResourceNotFoundException("categoryId not found"));

        categoryRepository.delete(category);
    }
}
