package com.bebe.spring.v2Dto.cartDto;

import com.bebe.spring.v2domain.CartV2;
import com.bebe.spring.v2domain.ProductV2;
import lombok.Data;

import java.util.List;

@Data
public class CartRequestDto {
    private String id;
    private Character dispYn;
    private Long cartNo;
    private Long productNo;
    private Long count;
    private String btn;
    private List<Long> productNoList;
    private List<ProductV2> productList;
    private List<Long> cartNoList;
}
