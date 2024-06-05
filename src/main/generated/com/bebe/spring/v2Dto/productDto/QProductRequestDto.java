package com.bebe.spring.v2Dto.productDto;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.bebe.spring.v2Dto.productDto.QProductRequestDto is a Querydsl Projection type for ProductRequestDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QProductRequestDto extends ConstructorExpression<ProductRequestDto> {

    private static final long serialVersionUID = -1667848526L;

    public QProductRequestDto(com.querydsl.core.types.Expression<String> categoryNo, com.querydsl.core.types.Expression<String> productName) {
        super(ProductRequestDto.class, new Class<?>[]{String.class, String.class}, categoryNo, productName);
    }

}

