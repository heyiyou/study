package com.cal.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.cal.dto.ProductDto;
import com.cal.service.ProductService;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping
    public List<ProductDto> getAllProducts() {
        return service.getAllProducts();
    }

    @GetMapping("/{id}")
    public ProductDto getProduct(@PathVariable int id) {
        return service.getProductById(id);
    }

    @GetMapping("/search")
    public Map<String, Object> searchProducts(
            @RequestParam(required = false) String keyword,
            @RequestParam(required = false) String category,
            //@RequestParam(defaultValue = "new") String sort,
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "8") int size) {

        ProductDto criteria = new ProductDto();
        criteria.setKeyword(keyword);
        criteria.setCategory(category);
        //criteria.setSort(sort);
        criteria.setPage(page);
        criteria.setSize(size);

        List<ProductDto> products = service.getProductsByCriteria(criteria);
        int total = service.getProductCount(criteria);

        Map<String, Object> result = new HashMap<>();
        result.put("products", products);
        result.put("total", total);
        result.put("page", page);
        result.put("size", size);
        return result;
    }
}
