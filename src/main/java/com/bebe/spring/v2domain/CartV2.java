package com.bebe.spring.v2domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "cart")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CartV2 extends Common{
    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "cartNo")
    private Long cartNo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id",nullable = false)
    private MemberV2 member = new MemberV2();

    private Long count;

    private Character dispYn;
    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.REMOVE,orphanRemoval = true)
    @JoinColumn(name = "product_no")
    private ProductV2 product = new ProductV2();

    public CartV2(String id, Long count, Long productNo, Character dispYn, Long cartNo) {
        this.member.setId(id);
        this.count = count;
        this.product.setProductNo(productNo);
        this.dispYn= dispYn;
        this.cartNo = cartNo;
    }
    public CartV2(String id, Long count, Long productNo,Character dispYn) {
        this.member.setId(id);
        this.count = count;
        this.product.setProductNo(productNo);
        this.dispYn= dispYn;
    }
}
