package com.bebe.spring.v2api;

import com.bebe.spring.v2Dto.cartDto.CartRequestDto;
import com.bebe.spring.v2Dto.cartDto.CartResponseDto;
import com.bebe.spring.v2domain.ApiResponse;
import com.bebe.spring.v2domain.CartV2;
import com.bebe.spring.v2domain.MemberV2;
import com.bebe.spring.v2domain.ProductV2;
import com.bebe.spring.v2exception.member.CartException;
import com.bebe.spring.v2service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/cart")
public class CartApiController {
    private final CartService cartService;
    @PostMapping("/save")
    public ResponseEntity<Object> saveCart(@RequestBody CartRequestDto cartRequestDto){
        ResponseEntity<Object> apiResponse = null;
        try{
            Long cartNo = cartService.saveCart(cartRequestDto);
            apiResponse = ResponseEntity.ok().body(cartNo);
        }catch(Exception e){
            apiResponse = ResponseEntity.badRequest().build();
        }

        return apiResponse;
    }

    @PostMapping("/delete")
    public ApiResponse deleteCart(@RequestBody CartRequestDto cartRequestDto){
        ApiResponse apiResponse = ApiResponse.builder().success(true).build();
        try{
            cartService.deleteCart(cartRequestDto);
        }catch(Exception e){
            apiResponse = ApiResponse.builder().success(false).message(e.getLocalizedMessage()).build();
        }

        return apiResponse;
    }

    @PostMapping("/deleteList")
    public ApiResponse deleteCartList(@RequestBody CartRequestDto cartRequestDto){
        ApiResponse apiResponse = ApiResponse.builder().success(true).build();
        try{
            cartService.deleteCartList(cartRequestDto);
        }catch(Exception e){
            apiResponse = ApiResponse.builder().success(false).message(e.getLocalizedMessage()).build();
        }

        return apiResponse;
    }

    @PostMapping("/findCart")
    public ResponseEntity<List<CartResponseDto>> member(@RequestBody CartRequestDto cartRequestDto){
        ResponseEntity<List<CartResponseDto>> apiResponse = null;
        try {
            List<CartResponseDto> body = cartService.findMemberCart(cartRequestDto);
            apiResponse = ResponseEntity.ok().body(body);
        }catch (Exception e){
            apiResponse = ResponseEntity.badRequest().build();
        }

        return apiResponse;
    }
    @PostMapping("/findOrderListCart")
    public ResponseEntity<List<CartResponseDto>> findOrderListCart(@RequestBody CartRequestDto cartRequestDto){
        ResponseEntity<List<CartResponseDto>> apiResponse = null;
        try {
            List<CartResponseDto> body = cartService.findOrderListCart(cartRequestDto);
            apiResponse = ResponseEntity.ok().body(body);
        }catch (Exception e){
            apiResponse = ResponseEntity.badRequest().build();
        }

        return apiResponse;
    }

}
