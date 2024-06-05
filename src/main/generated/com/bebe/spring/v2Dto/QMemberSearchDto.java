package com.bebe.spring.v2Dto;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.bebe.spring.v2Dto.QMemberSearchDto is a Querydsl Projection type for MemberSearchDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QMemberSearchDto extends ConstructorExpression<MemberSearchDto> {

    private static final long serialVersionUID = 1210098220L;

    public QMemberSearchDto(com.querydsl.core.types.Expression<String> id, com.querydsl.core.types.Expression<String> name, com.querydsl.core.types.Expression<String> tel) {
        super(MemberSearchDto.class, new Class<?>[]{String.class, String.class, String.class}, id, name, tel);
    }

}

