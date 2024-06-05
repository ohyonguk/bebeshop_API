package com.bebe.spring.v2Dto.cartDto;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.bebe.spring.v2Dto.cartDto.QCartResponseDto is a Querydsl Projection type for CartResponseDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QCartResponseDto extends ConstructorExpression<CartResponseDto> {

    private static final long serialVersionUID = 998029022L;

    public QCartResponseDto(com.querydsl.core.types.Expression<Long> cartNo, com.querydsl.core.types.Expression<Long> productNo, com.querydsl.core.types.Expression<String> productImg1, com.querydsl.core.types.Expression<Long> productPrice, com.querydsl.core.types.Expression<Long> count, com.querydsl.core.types.Expression<Character> dispYn, com.querydsl.core.types.Expression<String> productName) {
        super(CartResponseDto.class, new Class<?>[]{long.class, long.class, String.class, long.class, long.class, char.class, String.class}, cartNo, productNo, productImg1, productPrice, count, dispYn, productName);
    }

    public QCartResponseDto(com.querydsl.core.types.Expression<Long> cartNo, com.querydsl.core.types.Expression<Long> count) {
        super(CartResponseDto.class, new Class<?>[]{long.class, long.class}, cartNo, count);
    }

}

