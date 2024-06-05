package com.bebe.spring.v2Dto.cartDto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class CartResponseDto {
    private Long cartNo;
    private LocalDateTime modDate;
    private Long productNo;
    private String productImg1;
    private Long productPrice;
    private Long count;
    private Character dispYn;
    private String productName;

    @QueryProjection
    public CartResponseDto(Long cartNo, Long productNo, String productImg1,
                   Long productPrice, Long count, Character dispYn,String productName) {
        this.cartNo = cartNo;
        this.productNo = productNo;
        this.productImg1 = productImg1;
        this.productPrice = productPrice;
        this.count = count;
        this.dispYn = dispYn;
        this.productName = productName;
    }

    @QueryProjection
    public CartResponseDto(Long cartNo, Long count) {
        this.cartNo = cartNo;
        this.count = count;
    }
}
