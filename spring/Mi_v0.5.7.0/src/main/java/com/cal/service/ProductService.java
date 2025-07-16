package com.cal.service;

import java.util.List;

import com.cal.dto.ProductDto;


public interface ProductService {
    List<ProductDto> getAllProducts();
    ProductDto getProductById(int id);
    List<ProductDto> getProductsByCriteria(ProductDto criteria);
    int getProductCount(ProductDto criteria);
}