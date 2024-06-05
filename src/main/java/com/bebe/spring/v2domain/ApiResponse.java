package com.bebe.spring.v2domain;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class ApiResponse<T> {
    private boolean success;

    private String message;

    private T body;


}
