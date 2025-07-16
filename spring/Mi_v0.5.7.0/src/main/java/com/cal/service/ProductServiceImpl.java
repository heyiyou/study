package com.cal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cal.dto.ProductDto;
import com.cal.mapper.ProductMapper;

@Service
public abstract class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductMapper mapper;

	@Override
	public List<ProductDto> getAllProducts() {
		return mapper.findAll();
	}

	@Override
	public ProductDto getProductById(int id) {
		return mapper.findById(id);
	}

	@Override
	public List<ProductDto> getProductsByCriteria(ProductDto criteria) {
		return mapper.findWithCriteria(criteria);
	}

	@Override
	public int getProductCount(ProductDto criteria) {
		return mapper.countWithCriteria(criteria);
	}
}
