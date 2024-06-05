package com.bebe.spring.v2Dto;

import lombok.Data;

@Data
public class MemberRequestDto {
    private String id;
    private String nowPassword;
    private String password;
}
