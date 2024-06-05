package com.bebe.spring.v2Dto;

import com.querydsl.core.annotations.QueryProjection;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class MemberSearchDto {
    public MemberSearchDto() {
    }

    public MemberSearchDto(String id) {
        this.id = id;
    }

    public MemberSearchDto(String name, String tel) {
        this.name = name;
        this.tel = tel;
    }

    private String id;

    private String name;
    private String tel;

    @QueryProjection
    public MemberSearchDto(String id, String name, String tel) {
        this.id = id;
        this.name = name;
        this.tel = tel;
    }
}
