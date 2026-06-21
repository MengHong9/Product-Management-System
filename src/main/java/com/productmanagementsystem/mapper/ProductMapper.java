package com.productmanagementsystem.mapper;

import com.productmanagementsystem.dto.product.ProductDto;
import com.productmanagementsystem.dto.product.ProductResponseDto;
import com.productmanagementsystem.dto.product.ProductUpdateDto;
import com.productmanagementsystem.entity.Brand;
import com.productmanagementsystem.entity.Category;
import com.productmanagementsystem.entity.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductMapper {

    public Product toEntity(ProductDto dto) {
        Product product = new Product();
        product.setProductName(dto.getProductName());
        product.setPrice(dto.getPrice());
        product.setQuantity(dto.getQuantity());

        // Map Category ID to Category object
        if (dto.getCategoryId() != null) {
            Category category = new Category();
            category.setCategoryId(dto.getCategoryId());
            product.setCategory(category);
        }


        // Map Brand ID to Brand object
        if (dto.getBrandId() != null) {
            Brand brand = new Brand();
            brand.setBrandId(dto.getBrandId());
            product.setBrand(brand);
        }


        return product;
    }

    public ProductResponseDto toDto(Product product) {
        ProductResponseDto dto = new ProductResponseDto();
        dto.setProductId(product.getProductId());
        dto.setProductName(product.getProductName());
        dto.setPrice(product.getPrice());
        dto.setQuantity(product.getQuantity());
        if (product.getCategory() != null) {
            dto.setCategoryId(product.getCategory().getCategoryId());
        }
        if (product.getBrand() != null) {
            dto.setBrandId(product.getBrand().getBrandId());
        }
        dto.setCreatedDate(product.getCreatedDate());
        dto.setUpdatedDate(product.getUpdatedDate());
        return dto;
    }

    public List<ProductResponseDto> toDtoList(List<Product> products) {
        if (products == null || products.isEmpty()) {
            return new ArrayList<>();
        }

        return products.stream().map(entity->toDto(entity)).collect(Collectors.toList());
    }


    public void updateProduct(Product product , ProductUpdateDto dto){
        if (product == null || dto == null){
            return;
        }
            product.setProductName(dto.getProductName());
            product.setPrice(dto.getPrice());
            product.setQuantity(dto.getQuantity());

    }

}
