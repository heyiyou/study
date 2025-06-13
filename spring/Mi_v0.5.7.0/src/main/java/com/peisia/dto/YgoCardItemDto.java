package com.peisia.dto;

import lombok.Data;

@Data
public class YgoCardItemDto {
    public String cardId;
    public String cardName;
    public String cardType;
    public String attribute;
    public int level;
    public int atk;
    public int def;
    public String desc;
    }