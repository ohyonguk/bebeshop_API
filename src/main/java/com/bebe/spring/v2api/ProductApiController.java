package com.bebe.spring.v2api;

import com.bebe.spring.v2Dto.cartDto.CartRequestDto;
import com.bebe.spring.v2Dto.productDto.ProductResponseDto;
import com.bebe.spring.v2Dto.productDto.ProductRequestDto;
import com.bebe.spring.v2domain.ProductV2;
import com.bebe.spring.v2service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
@Slf4j
public class ProductApiController {
    private final ProductService productService;

    @PostMapping("/addOne")
    public void addProduct(@RequestBody ProductRequestDto productRequestDto){
        productService.addProduct(productRequestDto);
    }

    @PostMapping("/find")
    public ResponseEntity<List<ProductV2>> findProductList(@RequestBody ProductRequestDto productRequestDto){
        List<ProductV2> list  = productService.findProductList(productRequestDto);
        log.info("{}",list);
        return ResponseEntity.ok().body(list);
    }
    @PostMapping("/detail")
    public ProductResponseDto findProductDetail(@RequestBody ProductRequestDto productRequestDto){

        return productService.findProductDetail(productRequestDto);
    }

    @PostMapping("/productCntList")
    public ResponseEntity<Boolean> productCntList(@RequestBody CartRequestDto cartRequestDto){
        boolean cntChk = productService.productCntList(cartRequestDto);


        return ResponseEntity.ok().body(cntChk);
    }

}
