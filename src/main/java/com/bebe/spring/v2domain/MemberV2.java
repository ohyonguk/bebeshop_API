package com.bebe.spring.v2domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.querydsl.core.annotations.QueryProjection;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "member")
public class MemberV2 extends Common {
    @Id
    private String id;

    private String password;

    private String emailId;

    private String emailDomain;

    private String tel;

    private String name;

//    @JsonIgnore
//    @OneToMany(mappedBy = "member")
//    private List<ReviewV2> review;

//    @JsonIgnore
//    @OneToMany(mappedBy = "member")
//    private List<CartV2> cart;

    @JsonIgnore
    @OneToMany(mappedBy = "member")
    private List<OrdersV2> order;

    public MemberV2(String id) {
        this.id = id;
    }

    @QueryProjection
    public MemberV2(String id, String emailId, String emailDomain, String tel, String name) {
        this.id = id;
        this.emailId = emailId;
        this.emailDomain = emailDomain;
        this.tel = tel;
        this.name = name;
    }
}

