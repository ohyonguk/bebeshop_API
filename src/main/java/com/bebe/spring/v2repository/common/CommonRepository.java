package com.bebe.spring.v2repository.common;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

@Repository
public class CommonRepository {
    private final EntityManager entityManager;
    private final JPAQueryFactory jpaQueryFactory;

    /**
     * Instantiates a new Member repository.
     *
     * @param entityManager the entity manager
     */
    public CommonRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.jpaQueryFactory = new JPAQueryFactory(entityManager);
    }
}
