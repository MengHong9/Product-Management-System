package com.productmanagementsystem.controller;


import com.productmanagementsystem.common.response.Response;
import com.productmanagementsystem.dto.brand.BrandDto;
import com.productmanagementsystem.dto.brand.BrandResponseDto;
import com.productmanagementsystem.entity.Brand;
import com.productmanagementsystem.service.BrandService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/brands")
public class BrandController {
    @Autowired
    private BrandService brandService;


    @GetMapping
    public ResponseEntity<Response> getAllBrands() {
        List<BrandResponseDto> dtos = brandService.getBrands();
        return ResponseEntity.status(HttpStatus.OK).body(Response.success("200" , "success" , "successfully retrieved brands" , dtos));
    }


    @PostMapping
    public ResponseEntity<Response> addBrand(@Valid @RequestBody BrandDto dto) {
        brandService.createBrand(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(Response.success("201" , "success" , "successfully added brands" ));
    }

    @PutMapping("{brandId}")
    public ResponseEntity<Response> updateBrand(@PathVariable Long brandId , @Valid @RequestBody BrandDto dto){
        brandService.putBrand(brandId , dto);
        return ResponseEntity.status(HttpStatus.OK).body(Response.success("200" , "success" , "successfully updated brand"));
    }

    @DeleteMapping("{brandId}")
    public ResponseEntity<Response> updateBrand(@PathVariable Long brandId){
        brandService.deleteBrand(brandId);
        return ResponseEntity.status(HttpStatus.OK).body(Response.success("200" , "success" , "successfully deleted brand"));
    }
}
