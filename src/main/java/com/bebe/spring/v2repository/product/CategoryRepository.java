package com.bebe.spring.v2repository.product;

import com.bebe.spring.v2domain.CategoryV2;
import com.bebe.spring.v2domain.ProductV2;
import com.bebe.spring.v2domain.QCategoryV2;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jdk.jfr.Category;
import org.apache.catalina.util.StringUtil;
import org.springframework.stereotype.Repository;
import org.thymeleaf.util.StringUtils;

import java.util.List;

import static com.bebe.spring.v2domain.QCategoryV2.categoryV2;

@Repository
public class CategoryRepository {
    private final EntityManager entityManager;
    private final JPAQueryFactory jpaQueryFactory;

    /**
     * Instantiates a new Member repository.
     *
     * @param entityManager the entity manager
     */
    public CategoryRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.jpaQueryFactory = new JPAQueryFactory(entityManager);
    }

    public void createCategory(CategoryV2 categoryV2){
        entityManager.persist(categoryV2);
        entityManager.flush();
    }
    public List<CategoryV2> allCategory(CategoryV2 category){
        return jpaQueryFactory.select(categoryV2)
                .from(categoryV2)
                .fetch();
    }

    public CategoryV2 findCategory(CategoryV2 category){
        return jpaQueryFactory.select(categoryV2)
                .from(categoryV2)
                .where(categoryCondition(category.getCategoryNo(),category.getCategoryName()))
                .fetchOne();
    }

    private BooleanBuilder categoryCondition(String categoryNo,String categoryName) {
        return categoryNoEq(categoryNo).and(categoryNameEq(categoryName));
    }
    private BooleanBuilder categoryNoEq(String categoryNo){
        return categoryNo != null ? new BooleanBuilder(categoryV2.categoryNo.eq(categoryNo)) : null;
    }
    private BooleanBuilder categoryNameEq(String categoryName){
        return categoryName != null ? new BooleanBuilder(categoryV2.categoryName.eq(categoryName)) : null;
    }
}
