package com.bebe.spring.v2Dto.productDto;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.bebe.spring.v2Dto.productDto.QProductResponseDto is a Querydsl Projection type for ProductResponseDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QProductResponseDto extends ConstructorExpression<ProductResponseDto> {

    private static final long serialVersionUID = 534214716L;

    public QProductResponseDto(com.querydsl.core.types.Expression<Long> productNo, com.querydsl.core.types.Expression<String> categoryNo, com.querydsl.core.types.Expression<String> productImg1, com.querydsl.core.types.Expression<String> productImg2, com.querydsl.core.types.Expression<String> productImg3, com.querydsl.core.types.Expression<Long> productPrice, com.querydsl.core.types.Expression<String> productName, com.querydsl.core.types.Expression<Integer> productCnt, com.querydsl.core.types.Expression<? extends java.util.List<com.bebe.spring.v2domain.ReviewV2>> reviewList) {
        super(ProductResponseDto.class, new Class<?>[]{long.class, String.class, String.class, String.class, String.class, long.class, String.class, int.class, java.util.List.class}, productNo, categoryNo, productImg1, productImg2, productImg3, productPrice, productName, productCnt, reviewList);
    }

    public QProductResponseDto(com.querydsl.core.types.Expression<Long> productNo, com.querydsl.core.types.Expression<String> categoryNo, com.querydsl.core.types.Expression<String> productImg1, com.querydsl.core.types.Expression<String> productImg2, com.querydsl.core.types.Expression<String> productImg3, com.querydsl.core.types.Expression<Long> productPrice, com.querydsl.core.types.Expression<String> productName, com.querydsl.core.types.Expression<Integer> productCnt) {
        super(ProductResponseDto.class, new Class<?>[]{long.class, String.class, String.class, String.class, String.class, long.class, String.class, int.class}, productNo, categoryNo, productImg1, productImg2, productImg3, productPrice, productName, productCnt);
    }

}

