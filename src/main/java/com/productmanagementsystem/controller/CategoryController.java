package com.productmanagementsystem.controller;


import com.productmanagementsystem.common.response.Response;
import com.productmanagementsystem.dto.category.CategoryDto;
import com.productmanagementsystem.dto.category.CategoryResponseDto;
import com.productmanagementsystem.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {

@Autowired
private CategoryService categoryService;


    @GetMapping
    public ResponseEntity<Response> getAllCategories(){
        List<CategoryResponseDto> dtos = categoryService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(Response.success("200" , "success" , "successfully retrieved categories", dtos));
    }


    @PostMapping
    public ResponseEntity<Response> addCategory(@Valid @RequestBody CategoryDto dto){
        categoryService.addCategory(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(Response.success("201" , "success" , "successfully added category"));
    }

    @PutMapping("{categoryId}")
    public ResponseEntity<Response> updateProduct(@PathVariable Long categoryId , @Valid @RequestBody CategoryDto dto){
        categoryService.putCategory(categoryId , dto);
        return ResponseEntity.status(HttpStatus.OK).body(Response.success("200" , "success" , "successfully updated category"));
    }

    @DeleteMapping("{categoryId}")
    public ResponseEntity<Response> deleteCategory(@PathVariable Long categoryId){
        categoryService.deleteCategoryById(categoryId);
        return ResponseEntity.status(HttpStatus.OK).body(Response.success("200" , "success" , "successfully deleted category"));

    }
}
