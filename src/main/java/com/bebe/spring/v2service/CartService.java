package com.bebe.spring.v2service;

import com.bebe.spring.v2Dto.MemberSearchDto;
import com.bebe.spring.v2Dto.productDto.ProductResponseDto;
import com.bebe.spring.v2Dto.productDto.ProductRequestDto;
import com.bebe.spring.v2Dto.cartDto.CartRequestDto;
import com.bebe.spring.v2Dto.cartDto.CartResponseDto;
import com.bebe.spring.v2domain.CartV2;
import com.bebe.spring.v2domain.MemberV2;
import com.bebe.spring.v2exception.member.CartException;
import com.bebe.spring.v2repository.cart.CartRepository;
import com.bebe.spring.v2repository.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.List;

/**
 * The type Cart service.
 */
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CartService {
    private final CartRepository cartRepository;
    private final MemberRepository memberRepository;
    private final ProductService productService;

    /**
     * 장바구니 저장 및 추가
     *
     * @param cartRequestDto the cart request dto
     */
    @Transactional
    public Long saveCart(CartRequestDto cartRequestDto){
        CartResponseDto cartResponseDto = findCartForSaveCart(cartRequestDto);
        ProductResponseDto productResponseDto = findProduct(cartRequestDto);

        if(ObjectUtils.isEmpty(productResponseDto)){
            throw new CartException("없는 상품입니다.");
        }
        CartV2 cart = null;
        if(cartResponseDto!=null){
            if(cartRequestDto.getBtn().equals("order")){
                if(productResponseDto.getProductCnt()<cartRequestDto.getCount()){
                    throw new CartException("재고를 초과하여 담을 수 없습니다.");
                }
                cart = new CartV2(cartRequestDto.getId()
                        ,cartRequestDto.getCount()
                        ,cartRequestDto.getProductNo()
                        ,'N'
                        ,cartResponseDto.getCartNo());
            }else{
                if(productResponseDto.getProductCnt()<cartRequestDto.getCount()+ cartResponseDto.getCount()){
                    throw new CartException("재고를 초과하여 담을 수 없습니다.");
                }
                cart = new CartV2(cartRequestDto.getId()
                        ,cartRequestDto.getCount()+ cartResponseDto.getCount()
                        ,cartRequestDto.getProductNo()
                        ,'Y'
                        ,cartResponseDto.getCartNo());
            }
            cartRepository.saveUpdateCart(cart);

        }else{
            if(productResponseDto.getProductCnt()<cartRequestDto.getCount()){
                throw new CartException("재고를 초과하여 담을 수 없습니다.");
            }

            if(cartRequestDto.getBtn().equals("order")){
                cart = new CartV2(cartRequestDto.getId()
                        ,cartRequestDto.getCount()
                        ,cartRequestDto.getProductNo()
                        ,'N');
            }else{
                cart = new CartV2(cartRequestDto.getId()
                        ,cartRequestDto.getCount()
                        ,cartRequestDto.getProductNo()
                        ,'Y');
            }
            cartRepository.saveUpdateCart(cart);
        }
        return cart.getCartNo();
    }

    private ProductResponseDto findProduct(CartRequestDto cartRequestDto) {
        ProductRequestDto productRequestDto = new ProductRequestDto();
        productRequestDto.setProductNo(cartRequestDto.getProductNo());
        return productService.findProductDetail(productRequestDto);
    }

    /**
     * Find cart for save cart cart response dto.
     *
     * @param cartRequestDto the cart request dto
     * @return the cart response dto
     */
    public CartResponseDto findCartForSaveCart(CartRequestDto cartRequestDto){
        memberChk(cartRequestDto);
        return cartRepository.findCartForSaveCart(cartRequestDto);
    }


    /**
     * Find member cart list.
     *
     * @param cartRequestDto the cart request dto
     * @return the list
     */
    public List<CartResponseDto> findMemberCart(CartRequestDto cartRequestDto){
        memberChk(cartRequestDto);
        return cartRepository.findMemberCart(cartRequestDto);
    }

    public List<CartResponseDto> findOrderListCart(CartRequestDto cartRequestDto){
        memberChk(cartRequestDto);
        return cartRepository.findOrderListCart(cartRequestDto);
    }

    private void memberChk(CartRequestDto cartRequestDto) {
        if(ObjectUtils.isEmpty(memberIdChk(cartRequestDto))){
            throw new CartException("잘못된 id입니다.");
        }
    }

    private MemberV2 memberIdChk(CartRequestDto cartRequestDto) {
        return memberRepository.findMemberById(cartRequestDto.getId());
    }


    /**
     * Delete cart.
     *
     * @param cartRequestDto the cart request dto
     */
    @Transactional
    public void deleteCart(CartRequestDto cartRequestDto) {
        CartResponseDto cartResponseDto = findCartForSaveCart(cartRequestDto);
        if(cartResponseDto==null) {
            throw new CartException("잘못된 삭제요청입니다.");
        }


        CartV2 cart = new CartV2(cartRequestDto.getId()
                , 0L
                , cartRequestDto.getProductNo()
                , 'N'
                , cartResponseDto.getCartNo());
        cartRepository.saveUpdateCart(cart);
    }
    @Transactional
    public void deleteCartList(CartRequestDto cartRequestDto){
        for(Long productNo : cartRequestDto.getProductNoList()){
            CartRequestDto param = new CartRequestDto();
            param.setProductNo(productNo);
            param.setId(cartRequestDto.getId());
            deleteCart(param);
        }
    }
}
