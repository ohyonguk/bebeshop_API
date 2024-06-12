package com.bebe.spring.v2Dto.productDto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequestDto {

    private Long productNo;
    private String categoryNo;
    private String productName;
    private Integer productCnt;
    private Long productPrice;
    private String productImg1;
    private String productImg2;
    private String productImg3;
    private Integer offset;
    private Integer limit;
    public ProductRequestDto() {
    }
    @QueryProjection
    public ProductRequestDto(String categoryNo, String productName) {
        this.categoryNo = categoryNo;
        this.productName = productName;
    }
}
