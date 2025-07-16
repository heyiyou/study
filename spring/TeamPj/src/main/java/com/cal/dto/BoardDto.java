package com.cal.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class BoardDto {
   private int id;
   private String title;
   private String content;
   private String writer;
   private LocalDateTime createTime;
   private int productId;
   
   
}
