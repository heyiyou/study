package com.peisia.dto;

import lombok.Data;

@Data
public class MemberDto {
    private String id;
    private String pw;
    private String pw_re;
    private String name;
}