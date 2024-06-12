package com.bebe.spring.v2domain;

import com.bebe.spring.v2Dto.productDto.ProductRequestDto;
import com.bebe.spring.v2Dto.productDto.ProductResponseDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "product")
public class ProductV2 extends Common{
    @Id
    @GeneratedValue
    private Long productNo;

    private String categoryNo;

    private String productImg1;

    private String productImg2;

    private String productImg3;

    private Long productPrice;

    private String productName;

    private Integer productCnt;

    @OneToMany(mappedBy = "product")
    private List<ReviewV2> reviewList;

    public ProductV2() {
    }

    public ProductV2(ProductRequestDto productRequestDto) {
        this.categoryNo = productRequestDto.getCategoryNo();
        this.productImg1 = productRequestDto.getProductImg1();
        this.productImg2 = productRequestDto.getProductImg2();
        this.productImg3 = productRequestDto.getProductImg3();
        this.productPrice = productRequestDto.getProductPrice();
        this.productName = productRequestDto.getProductName();
        this.productCnt = productRequestDto.getProductCnt();
    }

    public ProductV2(ProductResponseDto productResponseDto, int cnt, String orderStat) {
        this.productNo = productResponseDto.getProductNo();
        this.categoryNo = productResponseDto.getCategoryNo();
        this.productImg1 = productResponseDto.getProductImg1();
        this.productImg2 = productResponseDto.getProductImg2();
        this.productImg3 = productResponseDto.getProductImg3();
        this.productPrice = productResponseDto.getProductPrice();
        this.productName = productResponseDto.getProductName();
        if(orderStat.equals("order")){
            this.productCnt = productResponseDto.getProductCnt()-cnt;
        }else if(orderStat.equals("cancel")){
            this.productCnt = productResponseDto.getProductCnt()+cnt;
        }else{
            this.productCnt = productResponseDto.getProductCnt();
        }

    }
}
