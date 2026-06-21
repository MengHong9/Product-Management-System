package com.productmanagementsystem.service;


import com.productmanagementsystem.dto.product.ProductDto;
import com.productmanagementsystem.dto.product.ProductResponseDto;
import com.productmanagementsystem.dto.product.ProductUpdateDto;
import com.productmanagementsystem.entity.Brand;
import com.productmanagementsystem.entity.Category;
import com.productmanagementsystem.entity.Product;
import com.productmanagementsystem.exception.ResourceNotFoundException;
import com.productmanagementsystem.mapper.ProductMapper;
import com.productmanagementsystem.repository.BrandRepository;
import com.productmanagementsystem.repository.CategoryRepository;
import com.productmanagementsystem.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;


    @Autowired
    private ProductMapper productMapper;


    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private BrandRepository brandRepository;


    public List<ProductResponseDto> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return productMapper.toDtoList(products);
    }


    public Product createProduct(ProductDto dto) {

        Product product = productMapper.toEntity(dto);


        if (dto.getBrandId() != null) {
            Brand brand = brandRepository.findById(dto.getBrandId())
                    .orElseThrow(() -> new ResourceNotFoundException("brandId not found"));

            product.setBrand(brand);
        }


        if (dto.getCategoryId() != null) {
            Category category = categoryRepository.findById(dto.getCategoryId())
                    .orElseThrow(() -> new ResourceNotFoundException("categoryId not found"));

            product.setCategory(category);
        }

        return productRepository.save(product);
    }


    public void updateProduct(Long productId , ProductUpdateDto dto){

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("productId not found"));


        productMapper.updateProduct(product , dto);


        if (dto.getCategoryId() != null){
            Category category = categoryRepository.findById(dto.getCategoryId())
                    .orElseThrow(() -> new ResourceNotFoundException("categoryId not found"));
            product.setCategory(category);
        }


        if (dto.getBrandId() != null) {
            Brand brand = brandRepository.findById(dto.getBrandId())
                    .orElseThrow(() -> new ResourceNotFoundException("brandId not found"));
            product.setBrand(brand);
        }

        productRepository.save(product);
    }


    public void deleteProduct(Long productId){
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("productId not found"));
        productRepository.delete(product);
    }


    public List<ProductResponseDto> findProductByName(String productName){
        List<Product> products = productRepository.findProductByProductNameContainingIgnoreCase(productName);
        if (products.isEmpty()){
            throw new ResourceNotFoundException("product name not found");
        }
        return productMapper.toDtoList(products);
    }

}
