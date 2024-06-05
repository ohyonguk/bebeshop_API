package com.bebe.spring.v2domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QReviewDetailV2 is a Querydsl query type for ReviewDetailV2
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QReviewDetailV2 extends EntityPathBase<ReviewDetailV2> {

    private static final long serialVersionUID = 1623103501L;

    public static final QReviewDetailV2 reviewDetailV2 = new QReviewDetailV2("reviewDetailV2");

    public final StringPath id = createString("id");

    public final NumberPath<Long> reviewLike = createNumber("reviewLike", Long.class);

    public final StringPath reviewNo = createString("reviewNo");

    public QReviewDetailV2(String variable) {
        super(ReviewDetailV2.class, forVariable(variable));
    }

    public QReviewDetailV2(Path<? extends ReviewDetailV2> path) {
        super(path.getType(), path.getMetadata());
    }

    public QReviewDetailV2(PathMetadata metadata) {
        super(ReviewDetailV2.class, metadata);
    }

}

