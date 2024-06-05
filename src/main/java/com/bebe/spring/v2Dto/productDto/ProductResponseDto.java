package com.bebe.spring.v2Dto.productDto;

import com.bebe.spring.v2domain.ReviewV2;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;

import java.util.List;

@Data
public class ProductResponseDto {
    private Long productNo;

    private String categoryNo;
    private String productImg1;
    private String productImg2;
    private String productImg3;
    private Long productPrice;
    private String productName;
    private Integer productCnt;
    private List<ReviewV2> reviewList;

    @QueryProjection
    public ProductResponseDto(Long productNo, String categoryNo, String productImg1, String productImg2, String productImg3, Long productPrice, String productName, Integer productCnt, List<ReviewV2> reviewList) {
        this.productNo = productNo;
        this.categoryNo = categoryNo;
        this.productImg1 = productImg1;
        this.productImg2 = productImg2;
        this.productImg3 = productImg3;
        this.productPrice = productPrice;
        this.productName = productName;
        this.productCnt = productCnt;
        this.reviewList = reviewList;
    }

    @QueryProjection
    public ProductResponseDto(Long productNo, String categoryNo, String productImg1, String productImg2, String productImg3, Long productPrice, String productName, Integer productCnt) {
        this.productNo = productNo;
        this.categoryNo = categoryNo;
        this.productImg1 = productImg1;
        this.productImg2 = productImg2;
        this.productImg3 = productImg3;
        this.productPrice = productPrice;
        this.productName = productName;
        this.productCnt = productCnt;
    }
    public ProductResponseDto(Long productNo, String productImg1, Long productPrice, String productName) {
        this.productNo = productNo;
        this.productImg1 = productImg1;
        this.productPrice = productPrice;
        this.productName = productName;
    }

    public ProductResponseDto() {

    }
}
