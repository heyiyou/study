package com.cal.mapper;

import java.util.List;

import com.cal.dto.ProductDto;

public interface ProductMapper {
    List<ProductDto> findAll();
    ProductDto findById(int id);
    List<ProductDto> findWithCriteria(ProductDto dto);
    int countWithCriteria(ProductDto dto);
}