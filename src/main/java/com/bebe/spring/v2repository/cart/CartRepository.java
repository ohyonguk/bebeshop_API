package com.bebe.spring.v2repository.cart;

import com.bebe.spring.v2Dto.cartDto.CartRequestDto;
import com.bebe.spring.v2Dto.cartDto.CartResponseDto;
import com.bebe.spring.v2Dto.cartDto.QCartResponseDto;
import com.bebe.spring.v2domain.CartV2;
import com.bebe.spring.v2domain.QProductV2;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.bebe.spring.v2domain.QCartV2.cartV2;


@Repository
public class CartRepository {
    private final EntityManager entityManager;
    private final JPAQueryFactory jpaQueryFactory;

    /**
     * Instantiates a new Member repository.
     *
     * @param entityManager the entity manager
     */
    public CartRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.jpaQueryFactory = new JPAQueryFactory(entityManager);
    }

    public void saveUpdateCart(CartV2 cart){
        if(cart.getCartNo()==null){
            entityManager.persist(cart);
        }else{
            entityManager.merge(cart);
        }
        entityManager.flush();
    }
    public void deleteCart(){

    }
    public CartResponseDto findCartForSaveCart(CartRequestDto cartRequestDto){
        return jpaQueryFactory.select(
                        new QCartResponseDto(cartV2.cartNo,cartV2.product.productNo,
                                cartV2.product.productImg1,
                                cartV2.product.productPrice,
                                cartV2.count,
                                cartV2.dispYn,
                                cartV2.product.productName)
                )
                .from(cartV2 )
                .join(cartV2.product)
                .where(cartV2.member.id.eq(cartRequestDto.getId()),productNullChk(cartRequestDto.getProductNo()))
                .fetchOne();
    }


    public List<CartResponseDto> findMemberCart(CartRequestDto cartRequestDto){
        return jpaQueryFactory.select(
                new QCartResponseDto(cartV2.cartNo,cartV2.product.productNo,
                        cartV2.product.productImg1,
                        cartV2.product.productPrice,
                        cartV2.count,
                        cartV2.dispYn,
                        cartV2.product.productName)
                )
                .from(cartV2 )
                .join(cartV2.product)
                .where(cartV2.member.id.eq(cartRequestDto.getId()),dispNullChk(cartRequestDto.getDispYn()),productNullChk(cartRequestDto.getProductNo()))
                .fetch();
    }

    public List<CartResponseDto> findOrderListCart(CartRequestDto cartRequestDto){
        return jpaQueryFactory.select(
                        new QCartResponseDto(cartV2.cartNo,cartV2.product.productNo,
                                cartV2.product.productImg1,
                                cartV2.product.productPrice,
                                cartV2.count,
                                cartV2.dispYn,
                                cartV2.product.productName)
                )
                .from(cartV2 )
                .join(cartV2.product)
                .where(cartV2.member.id.eq(cartRequestDto.getId()),productNullChk(cartRequestDto.getProductNo()),cartV2.cartNo.in(cartRequestDto.getCartNoList()))
                .fetch();
    }

    private BooleanBuilder productNullChk(Long productNo) {
        return productNo != null ? new BooleanBuilder(cartV2.product.productNo.eq(productNo)) : new BooleanBuilder();
    }

    private BooleanBuilder dispNullChk(Character dispYn) {
        return dispYn != null ? new BooleanBuilder(cartV2.dispYn.eq(dispYn)) : new BooleanBuilder();
    }

}
