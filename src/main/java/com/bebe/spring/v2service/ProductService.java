package com.bebe.spring.v2service;

import com.bebe.spring.v2Dto.cartDto.CartRequestDto;
import com.bebe.spring.v2Dto.productDto.ProductResponseDto;
import com.bebe.spring.v2Dto.productDto.ProductRequestDto;
import com.bebe.spring.v2domain.ProductV2;
import com.bebe.spring.v2exception.OrderException;
import com.bebe.spring.v2exception.member.CartException;
import com.bebe.spring.v2repository.product.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProductService {
    private final ProductRepository productRepository;

    @Transactional
    public void addProduct(ProductRequestDto productRequestDto){
        ProductV2 productV2 = new ProductV2(productRequestDto);
        productRepository.addProduct(productV2);
    }

    @Transactional
    public void addProductList(List<ProductV2> productV2List){
        productRepository.addListProduct(productV2List);
    }

    @Transactional
    public void deleteProduct(ProductRequestDto productRequestDto){
        productRepository.deleteProduct(productRequestDto);
    }

    public List<ProductV2> findProductList(ProductRequestDto productRequestDto){
        return  productRepository.findProductList(productRequestDto);
    }

    public ProductResponseDto findProductDetail(ProductRequestDto productRequestDto){
        ProductResponseDto product = new ProductResponseDto();
            product =  productRepository.findProductDetail(productRequestDto);

        return product;
    }


    public boolean productCntList(CartRequestDto cartRequestDto) {
        for(ProductV2 product : cartRequestDto.getProductList()){
            ProductRequestDto reqProduct = new ProductRequestDto();
            reqProduct.setProductNo(product.getProductNo());
            ProductResponseDto prd = findProductDetail(reqProduct);
            if(prd.getProductCnt()<product.getProductCnt()){
                return false;
            }
        }
        return true;

    }
}
