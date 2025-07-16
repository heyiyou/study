package com.cal.dto;

import lombok.Data;

@Data
public class ProductDto {
    private int id;
    private String name;
    private int price;
    private String category;
    private String imageUrl;
    private String keyword;
   
    private int page = 1;
    private int size = 8;

    public int getOffset() {
        return (page - 1) * size;
    }
}

