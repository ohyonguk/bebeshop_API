package com.bebe.spring.v2repository.product;

import com.bebe.spring.v2Dto.productDto.ProductRequestDto;
import com.bebe.spring.v2Dto.productDto.ProductResponseDto;
import com.bebe.spring.v2Dto.productDto.QProductResponseDto;
import com.bebe.spring.v2domain.*;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.thymeleaf.util.StringUtils;

import java.util.List;

import static com.bebe.spring.v2domain.QProductV2.productV2;


/**
 * The type Product repository.
 */
@Repository
public class ProductRepository {
    private final EntityManager entityManager;
    private final JPAQueryFactory jpaQueryFactory;

    /**
     * Instantiates a new Member repository.
     *
     * @param entityManager the entity manager
     */
    public ProductRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.jpaQueryFactory = new JPAQueryFactory(entityManager);
    }

    /**
     * Add list product.
     *
     * @param productV2List the product v 2 list
     */
    public void addListProduct(List<ProductV2> productV2List){
        entityManager.persist(productV2List);
    }

    /**
     * Add product.
     *
     * @param productV2 the product v 2
     */
    public void addProduct(ProductV2 productV2){
        if(productV2.getProductNo()==null){
            entityManager.persist(productV2);
        }else{
            entityManager.merge(productV2);
        }
    }

    /**
     * 상품 리스트 페이징
     *
     * @param productRequestDto the product search dto
     * @return the list
     */
    public List<ProductV2> findProductList(ProductRequestDto productRequestDto){
        return jpaQueryFactory
                .select(productV2)
                .from(productV2)
                .where(nameCategoryEq(productRequestDto))
                .offset(productRequestDto.getOffset())
                .limit(productRequestDto.getLimit())
                .fetch();
    }

    /**
     * 상품 디테일 정보를 가져오기 위한것
     *
     * @param productRequestDto the product request dto
     * @return the product v 2
     */
    public ProductResponseDto findProductDetail(ProductRequestDto productRequestDto){
        ProductResponseDto pr = new ProductResponseDto();
        pr = jpaQueryFactory.select(
                        new QProductResponseDto(
                                productV2.productNo,
                                productV2.categoryNo,
                                productV2.productImg1,
                                productV2.productImg2,
                                productV2.productImg3,
                                productV2.productPrice,
                                productV2.productName,
                                productV2.productCnt)
                )
                .from(productV2)
//                .join(productV2.reviewList).fetchJoin()
                .where(productV2.productNo.eq(productRequestDto.getProductNo()))
                .fetchOne();

        List<ReviewV2> reviewList = reviewList(productRequestDto);

        pr.setReviewList(reviewList);
        return pr;
    }


    public ProductResponseDto findProduct(ProductRequestDto productRequestDto){
        ProductResponseDto pr = new ProductResponseDto();
        pr = jpaQueryFactory.select(
                        new QProductResponseDto(
                                productV2.productNo,
                                productV2.categoryNo,
                                productV2.productImg1,
                                productV2.productImg2,
                                productV2.productImg3,
                                productV2.productPrice,
                                productV2.productName,
                                productV2.productCnt)
                )
//                .join(productV2.reviewList).fetchJoin()
                .where(productV2.productNo.eq(productRequestDto.getProductNo()))
                .fetchOne();


        return pr;
    }
    public List<ReviewV2> reviewList(ProductRequestDto productRequestDto){
        return jpaQueryFactory.selectFrom(QReviewV2.reviewV2)
                .join(QReviewV2.reviewV2.product)
                .where(QReviewV2.reviewV2.product.productNo.eq(productRequestDto.getProductNo()))
                .fetch();
    }


    private BooleanBuilder nameCategoryEq(ProductRequestDto productRequestDto) {
        return categoryEq(productRequestDto.getCategoryNo()).and(nameEq(productRequestDto.getProductName()));
    }

    private BooleanBuilder categoryEq(String categoryNo) {
        return categoryNo != null ? new BooleanBuilder(productV2.categoryNo.like(categoryNo+"%")) : new BooleanBuilder();
    }

    private BooleanBuilder nameEq(String productName) {
        return productName != null ? new BooleanBuilder(productV2.productName.like("%"+productName+"%")) : new BooleanBuilder();
    }

    public void deleteProduct(ProductRequestDto productRequestDto) {
        jpaQueryFactory.delete(QCartV2.cartV2)
                .where(QCartV2.cartV2.product.productNo.in(productRequestDto.getProductNoList()))
                .execute();
        jpaQueryFactory.delete(productV2)
               .where(productV2.productNo.in(productRequestDto.getProductNoList()))
               .execute();

        entityManager.flush();
        entityManager.clear();

    }
}
