package com.productmanagementsystem.controller;


import com.productmanagementsystem.common.response.Response;
import com.productmanagementsystem.dto.product.ProductDto;
import com.productmanagementsystem.dto.product.ProductResponseDto;
import com.productmanagementsystem.dto.product.ProductUpdateDto;
import com.productmanagementsystem.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    @Autowired
    private ProductService productService;


    @GetMapping
    public ResponseEntity<Response> getAllProducts() {
        List<ProductResponseDto> dtos = productService.getAllProducts();
        return ResponseEntity.status(HttpStatus.OK).body(Response.success("200" , "success" , "successfully retrieved product", dtos));
    }


    @PostMapping
    public ResponseEntity<Response> addProduct(@Valid @RequestBody ProductDto dto) {
        productService.createProduct(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(Response.success("201" , "success" , "successfully added product"));
    }


    @PutMapping("{productId}")
    public ResponseEntity<Response> updateProduct(@PathVariable Long productId , @Valid @RequestBody ProductUpdateDto dto){
        productService.updateProduct(productId , dto);
        return ResponseEntity.status(HttpStatus.OK).body(Response.success("200" , "success" , "successfully updated product"));
    }


    @DeleteMapping("{productId}")
    public ResponseEntity<Response> deleteProduct(@PathVariable Long productId){
        productService.deleteProduct(productId);
        return ResponseEntity.status(HttpStatus.OK).body(Response.success("200" , "success" , "successfully deleted product"));
    }

    @GetMapping("/search")
    public ResponseEntity<Response> getProductByName(@RequestParam String productName){
        List<ProductResponseDto> dtos = productService.findProductByName(productName);
        return ResponseEntity.status(HttpStatus.OK).body(Response.success("200" , "success" , "successfully retrieved product by name" , dtos));
    }
}
